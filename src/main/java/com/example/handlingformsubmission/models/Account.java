package com.example.handlingformsubmission.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
// import javax.persistence.NamedQuery;

// import org.springframework.data.annotation.Id;

@Entity
@Table(name = "author_user")
public class Account {

    @Id
    @Column(name = "acount")
    private String username;
    
    @Column(name = "password")
    private String password;

    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUserName() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account:" + this.username + "password" + this.password;
    }
}
