package bidReport.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * Created by pc-mg on 7/25/2018.
 */
@Entity
@Table(name = "report_content", schema = "public", catalog = "bidreport")
public class ReportContent {
    private int id;
    private Integer serialNumber;
    private String content;
    private int qty;
    private String unitMeasure;
    private BigInteger pricePerMeasure;
    private List<Report> reports;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "serial_number")
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "qty")
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "unit_measure")
    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    @Basic
    @Column(name = "price_per_measure")
    public BigInteger getPricePerMeasure() {
        return pricePerMeasure;
    }

    public void setPricePerMeasure(BigInteger pricePerMeasure) {
        this.pricePerMeasure = pricePerMeasure;
    }

    @OneToMany(mappedBy = "reportContent")
    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
