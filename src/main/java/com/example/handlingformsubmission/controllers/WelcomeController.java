package com.example.handlingformsubmission.controllers;

import java.util.List;

import com.example.handlingformsubmission.models.Account;
// import com.example.handlingformsubmission.repository.AccountRepository;
import com.example.handlingformsubmission.repository.CustomerRepository;
import com.example.handlingformsubmission.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    
    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String main(){
        return "home";
    }

    @GetMapping("/account/register")
    public String accountRegister() {
        return "register";
    }

    @PostMapping("/login")
    public String checking(@RequestParam(value = "username") String username, @RequestParam(value = "pass") String pass, Model model) {
        
        if (username == null || pass == null) {
            // message error
            System.out.println("Error");
            return "error";
        }
        
        String data = repo.findPassword(username);
        if (data.equals(pass)) {
            Account account = new Account(username, pass);
            model.addAttribute("account", account);
            return "welcome";
        }
        else {  return "error"; }
    }
    
}
