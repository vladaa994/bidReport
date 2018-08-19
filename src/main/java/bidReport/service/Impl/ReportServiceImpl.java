package bidReport.service.Impl;

import bidReport.helper.ReportHelper;
import bidReport.model.Report;
import bidReport.model.ReportContent;
import bidReport.model.User;
import bidReport.repository.ReportRepository;
import bidReport.service.ReportContentService;
import bidReport.service.ReportService;
import bidReport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
}
