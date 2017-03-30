package com.riverbank.data;

 /**
 * <p>
 * Created by @StanleyNguma on 29-Mar-17.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zizi_customers")
public class Customers {
    @Id
    private Integer id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String username;
    private String email;
    private String phone;
    private String idnumber;
    private String password;
    private Integer status;
    private Integer countyID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getMiddleName() {
        return middlename;
    }

    public void setMiddleName(String middleName) {
        this.middlename = middleName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCountyID() {
        return countyID;
    }

    public void setCountyID(Integer countyID) {
        this.countyID = countyID;
    }
}
