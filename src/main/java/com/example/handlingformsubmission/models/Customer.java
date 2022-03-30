package com.example.handlingformsubmission.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "customers")
public class Customer {
    
    @Id 
    @Column(name = "email")
    private String email;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "password")
    private String pass;


    public Customer() {}

    public Customer(String email, String fullname, String pass) {
        this.email = email;
        this.fullname = fullname;
        this.pass = pass;
    }
    
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return this.fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPass() {
        return this.pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
