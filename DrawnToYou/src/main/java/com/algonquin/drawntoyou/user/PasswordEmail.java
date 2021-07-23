package com.algonquin.drawntoyou.user;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PasswordEmail {
		
		public boolean sendEmail(User user) {
			boolean test = false;
				
			String toEmail = user.getEmail();
			String fromEmail = "drawn.to.you@outlook.com";
			String password = "iloveJava1";
			
			try {
				Properties pr = new Properties();
				pr.setProperty("mail.smtp.host", "smtp-mail.outlook.com");
				pr.setProperty("mail.smtp.port", "587");
				pr.setProperty("mail.smtp.auth", "true");
				pr.setProperty("mail.smtp.starttls.enable", "true");
				
				//get session
				Session session = Session.getInstance(pr, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
					    return new PasswordAuthentication(fromEmail, password);
					}
				});
				
				Message message = new MimeMessage(session);
				
				message.setFrom(new InternetAddress(fromEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
				
				message.setSubject("Drawn To You Password Recovery");
				message.setText("Requested password recovery from Drawn To You. Your password is:  " +
							user.getPassword() + ". Please use your password to login.");
				Transport.send(message);
				
				test = true;
				
			} catch(Exception e) {
				e.printStackTrace();
			}			
			return test;
		}

	}
