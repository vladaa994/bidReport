package bidReport.model;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by pc-mg on 7/25/2018.
 */
@Entity
public class Report {
    private int id;
    private String ownerName;
    private String ownerStreet;
    private String ownerWebsite;
    private int phone;
    private Integer fax;
    private int pib;
    private String bankAccount;
    private String email;
    private int reportNumber;
    private int reportYear;
    private String reportNote;
    private double sumPrice;
    private double pdvValue;
    private double sumPdv;
    private Client client;
    private ReportContent reportContent;
    private User user;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "owner_name")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Basic
    @Column(name = "owner_street")
    public String getOwnerStreet() {
        return ownerStreet;
    }

    public void setOwnerStreet(String ownerStreet) {
        this.ownerStreet = ownerStreet;
    }

    @Basic
    @Column(name = "owner_website")
    public String getOwnerWebsite() {
        return ownerWebsite;
    }

    public void setOwnerWebsite(String ownerWebsite) {
        this.ownerWebsite = ownerWebsite;
    }

    @Basic
    @Column(name = "phone")
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fax")
    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "pib")
    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    @Basic
    @Column(name = "bank_account")
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "report_number")
    public int getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    @Basic
    @Column(name = "report_year")
    public int getReportYear() {
        return reportYear;
    }

    public void setReportYear(int reportYear) {
        this.reportYear = reportYear;
    }

    @Basic
    @Column(name = "report_note")
    public String getReportNote() {
        return reportNote;
    }

    public void setReportNote(String reportNote) {
        this.reportNote = reportNote;
    }

    @Basic
    @Column(name = "sum_price")
    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    @Basic
    @Column(name = "pdv_value")
    public double getPdvValue() {
        return pdvValue;
    }

    public void setPdvValue(double pdvValue) {
        this.pdvValue = pdvValue;
    }

    @Basic
    @Column(name = "sum_pdv")
    public double getSumPdv() {
        return sumPdv;
    }

    public void setSumPdv(double sumPdv) {
        this.sumPdv = sumPdv;
    }


    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client clientByClientId) {
        this.client= clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "report_content_id", referencedColumnName = "id", nullable = false)
    public ReportContent getReportContent() {
        return reportContent;
    }

    public void setReportContent(ReportContent reportContent) {
        this.reportContent = reportContent;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User userByUserId) {
        this.user = userByUserId;
    }
}
