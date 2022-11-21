package com.example.demo;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	
    @Autowired
    private JavaMailSender mailSender;
    
    
    @Autowired
    Repo repo;

    public void sendSimpleEmailWithAttachment(String toEmail,
                                String subject, String body) {    
         
    	try {
    	MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(toEmail);
        helper.setText("<html><body><h1>hello Welcome!</h1><body></html>", true);
        FileSystemResource file  = new FileSystemResource(new File("C:\\elastic.txt"));
        helper.addAttachment("testfile", file);
        MimeMessageParser mp=new MimeMessageParser(message);
        System.out.println(mp);
        helper.setSubject("Hi");
        mailSender.send(message);

    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public void sendSimpleEmail(String toEmail,
            String subject,
            String body) {                      
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom("sumitmotihari1998@gmail.com");
      message.setTo(toEmail);
      message.setText(body);
      message.setSubject(subject);
      mailSender.send(message);
      System.out.println("Mail Send...");
    }
    
    

	public void saveEmails(List<Emailid> emails) {
		System.out.println(emails);
		repo.saveAll(emails);
	}
	
	
 }

