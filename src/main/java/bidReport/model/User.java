package bidReport.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

/**
 * Created by pc-mg on 7/23/2018.
 */
@Entity
@Table(name = "\"user\"")
public class User {

    private int id;

    @Size(min = 3, message = "Username must contain at least 3 characters.")
    private String username;
    @Size(min = 3, message = "Firstname must contain at least 3 characters.")
    private String firstname;
    @Size(min = 3, message = "Lastname must contain at least 3 characters.")
    private String lastname;
    @Size(min = 4, message = "Password must contain at least 4 characters.")
    private String password;
    private List<Report> reports;

    public User() {
    }

    public User(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
    }

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
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToMany(mappedBy = "user")
    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reportsById) {
        this.reports = reportsById;
    }
}
