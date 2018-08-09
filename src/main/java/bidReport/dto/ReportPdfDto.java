package bidReport.dto;

import bidReport.model.ReportContent;

import java.util.Date;
import java.util.List;

/**
 * Created by pc-mg on 8/8/2018.
 */
public class ReportPdfDto {
    private int id;
    private String ownerName;
    private String ownerStreet;
    private String ownerWebsite;
    private String phone;
    private String cellPhone;
    private Integer fax;
    private Integer pib;
    private String bankAccount;
    private String email;
    private Integer reportNumber;
    private Date reportYear;
    private String reportIdentification;
    private String reportNote;
    private Double sumPrice;
    private Double pdvValue;
    private Double sumPdv;
    private String clientName;
    private String clientStreet;
    private Integer clientPib;
    private List<ReportContent> reportContent;
    private String userFirstname;
    private String userLastname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerStreet() {
        return ownerStreet;
    }

    public void setOwnerStreet(String ownerStreet) {
        this.ownerStreet = ownerStreet;
    }

    public String getOwnerWebsite() {
        return ownerWebsite;
    }

    public void setOwnerWebsite(String ownerWebsite) {
        this.ownerWebsite = ownerWebsite;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public Integer getPib() {
        return pib;
    }

    public void setPib(Integer pib) {
        this.pib = pib;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(Integer reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Date getReportYear() {
        return reportYear;
    }

    public void setReportYear(Date reportYear) {
        this.reportYear = reportYear;
    }

    public String getReportIdentification() {
        return reportIdentification;
    }

    public void setReportIdentification(String reportIdentification) {
        this.reportIdentification = reportIdentification;
    }

    public String getReportNote() {
        return reportNote;
    }

    public void setReportNote(String reportNote) {
        this.reportNote = reportNote;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Double getPdvValue() {
        return pdvValue;
    }

    public void setPdvValue(Double pdvValue) {
        this.pdvValue = pdvValue;
    }

    public Double getSumPdv() {
        return sumPdv;
    }

    public void setSumPdv(Double sumPdv) {
        this.sumPdv = sumPdv;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientStreet() {
        return clientStreet;
    }

    public void setClientStreet(String clientStreet) {
        this.clientStreet = clientStreet;
    }

    public Integer getClientPib() {
        return clientPib;
    }

    public void setClientPib(Integer clientPib) {
        this.clientPib = clientPib;
    }

    public List<ReportContent> getReportContent() {
        return reportContent;
    }

    public void setReportContent(List<ReportContent> reportContent) {
        this.reportContent = reportContent;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }
}
