package com.algonquin.drawntoyou.user;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	public String verificationCode() {
		
		Random rand = new Random();
		int verificationCode = rand.nextInt(9999);
		return String.format("%04d", verificationCode);
	}
	
	public boolean sendEmail(String email, int code) {
		boolean test = false;
			
		String toEmail = email;
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
			
			message.setSubject("Drawn To You User Verification");
			message.setText("Registerd to Drawn To You successfully. Please verify your account using the verification"
					+ "code provided in this email. \n Verification code: " + code);
			Transport.send(message);
			
			test = true;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return test;
	}

}
