package reservation.metier.user;

import reservation.model.User;
import javax.validation.constraints.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class UserAdd {
    protected final Log logger = LogFactory.getLog(getClass());
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String firstName;
    @Email
    private String email;
    @Pattern(regexp="^[+]?[0-9]{8,}$")
    private String telephone;
    private String address;
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
    @NotEmpty
    private String role;
    private String error;
    
    public User getUser(){
        return new User(-1, lastName, firstName, email, telephone, address, login, password, role);
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lname) {
        this.lastName = lname;
        logger.info("UserAdd: name set to "+ lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        logger.info("UserAdd: first name set to "+ firstName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
        logger.info("UserAdd: mail set to "+ mail);
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
        logger.info("UserAdd: telephone set to "+ telephone);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        logger.info("UserAdd: address set to "+ address);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        logger.info("UserAdd: login set to "+ login);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        logger.info("UserAdd: password set to "+ password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
        logger.info("UserAdd: role set to "+ role);
    }
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
