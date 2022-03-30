package com.example.handlingformsubmission.controllers;

import com.example.handlingformsubmission.repository.CustomerRepository;
import com.example.handlingformsubmission.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository repoAcc;

    @Autowired
    private CustomerRepository repoCus;


    @PostMapping("/register")
    public String registerAccount(@RequestParam(value = "email") String email, @RequestParam(value = "res_pass") String pass, @RequestParam(value = "verify_pass") String verifyPass, @RequestParam(value = "full_name") String fullName) {

        repoAcc.insertAccount(email, pass);
        repoCus.insertCustomer(email, fullName, pass);
        // repoAcc.insertAccount(email, pass);
        // System.out.println(fullName);
        // System.out.println(email);
        // System.out.println(pass);
        // System.out.println(verifyPass);
        return "thank";
    }

}
