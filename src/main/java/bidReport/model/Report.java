package bidReport.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by pc-mg on 7/25/2018.
 */
@Entity
public class Report {
    private int id;
    private String ownerName;
    private String ownerStreet;
    private String ownerWebsite;
    private Integer phone;
    private Integer cellPhone;
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
    private Client client;
    private List<ReportContent> reportContent;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "cell_phone")
    public Integer getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Integer cellPhone) {
        this.cellPhone = cellPhone;
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
    public Integer getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(Integer reportNumber) {
        this.reportNumber = reportNumber;
    }

    @Basic
    @Column(name = "report_year")
    public Date getReportYear() {
        return reportYear;
    }

    public void setReportYear(Date reportYear) {
        this.reportYear = reportYear;
    }

    @Basic
    @Column(name = "report_identification")
    public String getReportIdentification() {
        return reportIdentification;
    }

    public void setReportIdentification(String reportIdentification) {
        this.reportIdentification = reportIdentification;
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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client= client;
    }

    @OneToMany(mappedBy = "report", fetch = FetchType.EAGER)
    public List<ReportContent> getReportContent() {
        return reportContent;
    }

    public void setReportContent(List<ReportContent> reportContent) {
        this.reportContent = reportContent;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
