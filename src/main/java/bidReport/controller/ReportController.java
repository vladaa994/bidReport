package bidReport.controller;

import bidReport.dto.ReportPdfDto;
import bidReport.helper.ReportHelper;
import bidReport.model.Client;
import bidReport.model.Report;
import bidReport.model.ReportContent;
import bidReport.service.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by pc-mg on 7/26/2018.
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportHelper reportHelper;

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
        else {
            return new ResponseEntity<>("Error saving report!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/pdf/{id}")
    public void generateReportById(@PathVariable int id, HttpServletResponse response) {
        Optional<Report> report = reportService.findById(id);

        if(report.isPresent()) {

            try {
                JasperPrint jasperPrint = reportService.generateReport(report.get());
                response.setContentType("application/x-pdf");
                response.setHeader("Content-Disposition", "inline; filename=ponuda.pdf");
                final OutputStream outputStream = response.getOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            }
            catch (JRException ex) {
                ex.printStackTrace();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
