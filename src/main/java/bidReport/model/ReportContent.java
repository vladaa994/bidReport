package bidReport.model;

import javax.persistence.*;

/**
 * Created by pc-mg on 7/25/2018.
 */
@Entity
@Table(name = "report_content")
public class ReportContent {
    private int id;
    private Integer serialNumber;
    private String content;
    private Integer qty;
    private String unitMeasure;
    private Double pricePerMeasure;
    private Report report;


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
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
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
    public Double getPricePerMeasure() {
        return pricePerMeasure;
    }

    public void setPricePerMeasure(Double pricePerMeasure) {
        this.pricePerMeasure = pricePerMeasure;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id", referencedColumnName = "id", nullable = false)
    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
