package com.stockmanager.fst.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class Email implements Serializable {

	private static final long serialVersionUID = 1L;
	String email;
	String password;
	String emailTo;
	String subject;
	String message;
	MultipartFile file;
	
	
	
	public Email() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
