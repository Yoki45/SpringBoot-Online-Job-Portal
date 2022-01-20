package net.javaguides.springboot.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Controller
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

     @GetMapping("/contact")
    public String ShowContactForm(){

         return "contact";

    }

    @PostMapping("/contact")

     public String SendMail( HttpServletRequest request,
                   @RequestParam("attachment") MultipartFile multipartFile
    ) throws MessagingException {


         String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        //SimpleMailMessage message = new SimpleMailMessage();


        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);



        helper.setFrom("@gmail.com");
        helper.setTo("@gmail.com");

        String mailSubject = fullname +  " " + "has send you a message";
        String mailBody = "<p><b>Sender Name:</b>" + fullname + "</p>";
        mailBody += "<p><b>Sender Email </b>" + email  + "</p>";
        mailBody += "<p><b>Subject </b>" + subject  + "</p>";
        mailBody += " <p><b>Body </b>" + body  + "</p>";

        helper.setSubject(mailSubject);
        helper.setText(mailBody,true);

        if(!multipartFile.isEmpty()){
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

            InputStreamSource source = new InputStreamSource() {

                @Override
                public InputStream getInputStream() throws IOException {
                    return multipartFile.getInputStream();
                }
            };


            helper.addAttachment(fileName,source);


        }




        mailSender.send(message);


        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");






         return "message";
    }




}
