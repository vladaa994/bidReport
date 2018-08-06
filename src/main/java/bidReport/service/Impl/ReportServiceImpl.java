package bidReport.service.Impl;

import bidReport.helper.ReportHelper;
import bidReport.model.Report;
import bidReport.model.User;
import bidReport.repository.ReportRepository;
import bidReport.service.ReportService;
import bidReport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, UserService userService, ReportHelper reportHelper) {
        this.reportRepository = reportRepository;
        this.userService = userService;
        this.reportHelper = reportHelper;
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
            Report lastReport = reportRepository.findTopByOrderById();
            if(lastReport != null) {
                report.setReportNumber(lastReport.getReportNumber() + 1);
            }
        }

        reportHelper.setOwnerDetails(report);
        report.setReportYear(new Date());
        report.setReportIdentification(reportHelper.generateReportIdentification(report.getReportNumber(), report.getReportYear()));
        report.setReportContent(report.getReportContent());
        //sum price
        double price = 0;
        price = report.getReportContent().stream()
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
