package bidReport.helper;

import bidReport.dto.ReportPdfDto;
import bidReport.enums.OwnerEnum;
import bidReport.model.Report;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by pc-mg on 7/28/2018.
 */
@Component
public class ReportHelper {

    public String generateReportIdentification(int reportNumber, Date date) {
        String reportIdent;
        LocalDate date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String fYear = String.valueOf(date1.getYear());
        String year = fYear.substring(2);

        if(reportNumber < 10) {
            DecimalFormat df = new DecimalFormat("00");
            String rNumberFormatted = df.format(reportNumber);
            reportIdent = String.format("%s/%s", rNumberFormatted, year);
            return reportIdent;
        }
        else {
            reportIdent = String.format("%s/%s", reportNumber, year);
            return reportIdent;
        }
    }

    public void setOwnerDetails(Report report) {
        report.setOwnerName(OwnerEnum.OWNER_NAME.getContent());
        report.setOwnerStreet(OwnerEnum.OWNER_ADDRESS.getContent());
        report.setPhone(Integer.valueOf(OwnerEnum.OWNER_PHONE.getContent()));
        report.setCellPhone(Integer.valueOf(OwnerEnum.OWNER_CELL_PHONE.getContent()));
        report.setBankAccount(OwnerEnum.OWNER_ACCOUNT.getContent());
        report.setEmail(OwnerEnum.OWNER_EMAIL.getContent());
        report.setPib(Integer.valueOf(OwnerEnum.OWNER_PIB.getContent()));
    }

    public ReportPdfDto setReportPdf(Report reportPdf) {
        ReportPdfDto pdf = new ReportPdfDto();
        //add 0 to phone number
        DecimalFormat df = new DecimalFormat("0000000000");
        String phone = df.format(reportPdf.getPhone());
        DecimalFormat cff = new DecimalFormat("0000000000");
        String cellPhone = cff.format(reportPdf.getCellPhone());
        pdf.setPhone(phone);
        pdf.setCellPhone(cellPhone);
        pdf.setOwnerName(reportPdf.getOwnerName());
        pdf.setOwnerStreet(reportPdf.getOwnerStreet());
        pdf.setOwnerWebsite(reportPdf.getOwnerWebsite());
        pdf.setFax(reportPdf.getFax());
        pdf.setPib(reportPdf.getPib());
        pdf.setBankAccount(reportPdf.getBankAccount());
        pdf.setEmail(reportPdf.getEmail());
        pdf.setReportNumber(reportPdf.getReportNumber());
        pdf.setReportYear(reportPdf.getReportYear());
        pdf.setReportIdentification(reportPdf.getReportIdentification());
        pdf.setReportNote(reportPdf.getReportNote());
        pdf.setSumPrice(reportPdf.getSumPrice());
        pdf.setPdvValue(reportPdf.getPdvValue());
        pdf.setSumPdv(reportPdf.getSumPdv());
        pdf.setClientName(reportPdf.getClient().getName());
        pdf.setClientStreet(reportPdf.getClient().getStreet());
        pdf.setClientPib(reportPdf.getClient().getPib());
        pdf.setReportContent(reportPdf.getReportContent());
        pdf.setUserFirstname(reportPdf.getUser().getFirstname());
        pdf.setUserLastname(reportPdf.getUser().getLastname());

        return pdf;
    }
}
