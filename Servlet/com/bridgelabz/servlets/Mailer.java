package com.bridgelabz.servlets;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Mailer
 */
@WebServlet("/Mailer")
public class Mailer  {
	
	public static void send(String username,String email) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message="Hello <username>,You just signed up to my site \n Thank you!";
		message=message.replaceFirst("<username>", username);
		 Properties props = new Properties();    
         props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "465");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "465");
         
         Session session = Session.getDefaultInstance(props,    
                 new javax.mail.Authenticator() {    
                 protected PasswordAuthentication getPasswordAuthentication() {    
                 return new PasswordAuthentication("chincholkarsujit1@gmail.com","88985150441");  
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
