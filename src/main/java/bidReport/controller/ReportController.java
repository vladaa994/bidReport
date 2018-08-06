package bidReport.controller;

import bidReport.model.Client;
import bidReport.model.Report;
import bidReport.model.ReportContent;
import bidReport.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc-mg on 7/26/2018.
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/list")
    public String listReport(Model model) {
        List<Report> reports = reportService.findAll();
        model.addAttribute("reports", reports);
        return "report/list";
    }

    @GetMapping(value = "/create")
    public String getReport(Model model) {
        ReportContent reportContent = new ReportContent();
        List<ReportContent> reportContentList = new ArrayList<>();
        reportContentList.add(reportContent);

        Report report = new Report();
        report.setReportContent(reportContentList);
        report.setClient(new Client());

        model.addAttribute("report", report);
        return "report/create";
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Report report) {
        Report report1 = reportService.save(report);
        if(report1 != null) {
            return new ResponseEntity<>(report1, HttpStatus.OK);
        }
        return new ResponseEntity<>("Error happen", HttpStatus.BAD_REQUEST);
    }
}
