package com.example.handlingformsubmission.models;

import org.thymeleaf.spring5.processor.SpringActionTagProcessor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
// import javax.persistence.NamedQuery;

// import org.springframework.data.annotation.Id;

@Entity
@Table(name = "users")
public class DetailUser {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private  String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "password")
    private String password;

    private boolean enabled;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    public DetailUser() {
    }

    public DetailUser(String email,
                      String firstName,
                      String lastName,
                      String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
