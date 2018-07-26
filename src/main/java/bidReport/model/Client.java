package bidReport.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by pc-mg on 7/25/2018.
 */
@Entity
public class Client {
    private int id;
    private String name;
    private String street;
    private int pib;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "pib")
    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }


    @OneToMany(mappedBy = "client")
    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
