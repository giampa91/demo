package com.example.demo.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UtenteRepository;
import com.example.demo.entity.Utente;
import com.example.demo.service.EmailService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.UtenteServiceImpl;

@RestController
public class EmailRestController {
	
	@Autowired
	EmailService emailService;

	@GetMapping("/testEmail")
	public void testEmail() throws MessagingException {
		this.emailService.send("giampaorr@gmail.com", "emailProva@gmail.com", "oggetto", "contenuto");
	}

}
