package com.stockmanager.fst.model.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {

	public int sendMail(String email, String password, String emailTo, String subject, String message,
			MultipartFile file) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(emailTo, false));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			msg.setSubject(subject);
			msg.setContent(message, "text/html");
			msg.setSentDate(new Date());
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			MimeBodyPart attachPart = new MimeBodyPart();
			attachPart.setContent(file.getBytes(), file.getContentType());
			attachPart.setFileName(file.getOriginalFilename());
			attachPart.setDisposition(Part.ATTACHMENT);
			multipart.addBodyPart(attachPart);
			msg.setContent(multipart);
			try {
				Transport.send(msg);
				return 1;
			} catch (SendFailedException e) {
				e.printStackTrace();
				return 0;
			}

		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}

	}

}
