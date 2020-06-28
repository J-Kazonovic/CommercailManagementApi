package com.stockmanager.fst.model.ws;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.Email;
import com.stockmanager.fst.model.service.impl.EmailService;

@RestController
@RequestMapping("/email")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class EmailRest {
	
	private EmailService emailService;
	
	
	@Autowired
	public EmailRest(EmailService emailService) {
		super();
		this.emailService = emailService;
	}



	@PostMapping("/")
	public int mail(@RequestParam("address")String email,@RequestParam("password") String password,@RequestParam("emailTo") String emailTo
			,@RequestParam("subject") String subject,@RequestParam("message") String message,@RequestParam("file") MultipartFile file){
			return emailService.sendMail(email,password
					,emailTo,subject,message,file);
	
	}


	

}
