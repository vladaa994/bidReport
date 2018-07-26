package bidReport;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by pc-mg on 7/26/2018.
 */
public class UserUpdateDto {
    private int id;

    @Size(min = 3, message = "Username must contain at least 3 characters.")
    private String username;
    @Size(min = 3, message = "Firstname must contain at least 3 characters.")
    private String firstname;
    @Size(min = 3, message = "Lastname must contain at least 3 characters.")
    private String lastname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
