package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;

public class Mailer {
	public static void send(String email,String message) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 Properties properties = new Properties();    
         properties.put("mail.smtp.host", "smtp.gmail.com");    
         properties.put("mail.smtp.socketFactory.port", "465");    
         properties.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         properties.put("mail.smtp.auth", "true");    
         //properties.put("mail.smtp.port", "465");
         
         Session session = Session.getDefaultInstance(properties,    
                 new javax.mail.Authenticator() {    
                 protected PasswordAuthentication getPasswordAuthentication() {    
                 return new PasswordAuthentication("chincholkarsujit1@gmail.com","");  
                 }    
                });    
         try {    
             MimeMessage mimeMessage = new MimeMessage(session);   
             mimeMessage.addHeader("from","chincholkarsujit1@gmail.com");
             mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(email));    
             mimeMessage.setSubject("Login");    
             mimeMessage.setText(message);    
             //send message  
             Transport.send(mimeMessage);    
             System.out.println("message sent successfully");    
            } catch (Exception e) {e.printStackTrace();}    
	}

}
