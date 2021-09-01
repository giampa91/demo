package com.example.demo.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;

	// per test usare https://ethereal.email
	public void send(String from, String to, String subject, String content) throws MessagingException {

		MimeMessage mimeMessage = this.mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);

		mimeMessage.setContent(content, "text/html");

		this.mailSender.send(mimeMessage);

	}

}
