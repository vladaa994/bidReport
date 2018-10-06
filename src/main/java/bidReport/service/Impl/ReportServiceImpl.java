package bidReport.service.Impl;

import bidReport.dto.ReportPdfDto;
import bidReport.helper.ReportHelper;
import bidReport.model.Report;
import bidReport.model.ReportContent;
import bidReport.model.User;
import bidReport.repository.ReportRepository;
import bidReport.service.ReportContentService;
import bidReport.service.ReportService;
import bidReport.service.UserService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by pc-mg on 7/27/2018.
 */
@Service
public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;
    private UserService userService;
    private ReportHelper reportHelper;
    private ReportContentService reportContentService;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, UserService userService, ReportHelper reportHelper, ReportContentService reportContentService) {
        this.reportRepository = reportRepository;
        this.userService = userService;
        this.reportHelper = reportHelper;
        this.reportContentService = reportContentService;
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> findById(int id) {
        return reportRepository.findById(id);
    }



    @Override
    public Report save(Report report) {
        //find user who created report
        Optional<User> user = userService.findById(1);

        //check if report number is set, if not increment previous by 1
        if(report.getReportNumber() == null) {
            int lastReport = reportRepository.findLast();
            report.setReportNumber( lastReport + 1);
        }

        reportHelper.setOwnerDetails(report);
        report.setReportYear(new Date());
        report.setReportIdentification(reportHelper.generateReportIdentification(report.getReportNumber(), report.getReportYear()));

        List<ReportContent> reportContents = new ArrayList<>();
        reportContents.addAll(report.getReportContent());
        report.addReportContent(reportContents);

        //sum price
        double price = report.getReportContent().stream()
                .mapToDouble(p -> p.getPricePerMeasure() * p.getQty())
                .sum();
        report.setSumPrice(price);
        double pricePDV = price * 0.2;
        report.setPdvValue(pricePDV);
        double sumPdv = price + pricePDV;
        report.setSumPdv(sumPdv);
        user.ifPresent(report::setUser);
        return reportRepository.save(report);

    }


    @Override
    public Report update(Report userUpdateDto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public JasperPrint generateReport(Report report) {
        List<ReportPdfDto> reports = new ArrayList<>();
        List<ReportContent> reportContents = new ArrayList<>();
        JasperPrint jasperPrint = null;
        try {
            ReportPdfDto reportPdfDto = reportHelper.setReportPdf(report);
            reports.add(reportPdfDto);
            reportContents.addAll(report.getReportContent());
            reportContents.forEach(rc -> rc.setPricePerMeasure(rc.getQty() * rc.getPricePerMeasure()));
            InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("reports/bidReport.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(jasperStream);
            JasperReport report2 = JasperCompileManager.compileReport(jasperDesign);

            Map<String, Object> parameterMap = new HashMap<>();
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(reports);
            JRDataSource jrReportContent = new JRBeanCollectionDataSource(reportContents);
            parameterMap.put("datasource", jrDataSource);
            parameterMap.put("reportContent", jrReportContent);

            jasperPrint = JasperFillManager.fillReport(report2, parameterMap, jrDataSource);
        }
        catch (JRException ex){
            ex.printStackTrace();
        }
        return jasperPrint;
    }
}
