package com.example.handlingformsubmission.services;

import com.example.handlingformsubmission.models.DetailUser;
import com.example.handlingformsubmission.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JavaMailSender mailSender;

    public void register(@NotNull DetailUser user, String siteUrl)
            throws UnsupportedEncodingException, MessageRemovedException {

        String pass = user.getPassword();
        user.setPassword(pass);

        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);

        repo.save(user);

        sendVerificationEmail(user, siteUrl);
    }

    private void sendVerificationEmail(DetailUser user, String siteUrl) {

        String toAddress = user.getEmail();
        String senderName = "Web shop sport";
        String fromAddress = "thng1642@gamil.com";
        String subject = "Please verify you registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        content = content.replace("[[name]]", user.getLastName());
        String verifyUrl = siteUrl + "/verify?code=" + user.getVerificationCode();
        content = content.replace("[[URL]]", verifyUrl);

        try {
            helper.setText(content,true);
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        mailSender.send(message);
    }
}
