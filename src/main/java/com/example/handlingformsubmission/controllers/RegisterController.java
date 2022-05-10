package com.example.handlingformsubmission.controllers;

//import com.example.handlingformsubmission.repository.CustomerRepository;
import com.example.handlingformsubmission.models.DetailUser;
import com.example.handlingformsubmission.repository.UserRepository;

import com.example.handlingformsubmission.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessageRemovedException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository repoAcc;

    @Autowired
    private UserServices services;

    @GetMapping("/verify")
    public String verifyUser(@RequestParam("code") String code) {

        // Xác nhận code ở đây
        System.out.println(code);
        return "welcome";
    }

    @PostMapping("/register")
    public String registerAccount(@RequestParam(value = "email") String email,
                                  @RequestParam(value = "password") String pass,
                                  @RequestParam(value = "verify_pass") String verifyPass,
                                  @RequestParam(value = "lastname") String lastName,
                                  @RequestParam(value = "firstname") String firstName,
                                  HttpServletRequest request) {

        DetailUser user = new DetailUser();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(pass);
        user.setEmail(email);


//        String siteUrl = request.getServletPath().toString();
//        System.out.println(siteUrl);
        try {
            services.register(user, getSiteURL(request));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MessageRemovedException e) {
            e.printStackTrace();
        }

        System.out.println(email);
        System.out.println(pass);

        return "thank";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

}
