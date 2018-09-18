package org.myrh.service;

import java.util.Map;
import java.util.TreeMap;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.myrh.entities.HTMLMail;
import org.myrh.entities.Reservation;
import org.myrh.entities.SimpleMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class MailSenderService {
	
	 @Autowired
	    private JavaMailSender mailSender;

	    // Use it to send Simple text emails
	    public void sendSimpleMail(SimpleMail mail) {

	        SimpleMailMessage message = new SimpleMailMessage();

	        message.setTo(mail.getTo());
	        message.setSubject(mail.getSubject());
	        message.setText(mail.getContent());

	        mailSender.send(message);
	        
	    } 

	 // Use it to send HTML emails
	    public void sendHTMLMail(HTMLMail mail,Reservation r) throws MessagingException {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
	        helper.setTo(mail.getTo());
	        helper.setSubject(mail.getSubject());
	        helper.setSubject(" Notification Commande Myhr : "+r.getId());
	        message.setContent(mail.getContent(), "text/html");
	    message.setContent
	    ( 
	    		"<html>" +
                "<body>" +
                "<p>E-mail <strong> "+r.getEmail()+"</strong> </p>" +
                "<p>Télephone<strong> "+r.getTelephone()+"</strong> </p>" +
                "<p>Localisation<strong> "+r.getVille()+"</strong> </p>" +
                "<p>Object<strong> "+r.getObjet()+"</strong> </p>" +
            "</body>" +
        "</html>", "text/html");
	        mailSender.send(message);
	        
	    }
	    

}
