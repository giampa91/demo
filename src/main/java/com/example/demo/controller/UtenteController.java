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
public class UtenteController {
	
	@Autowired
	UtenteServiceImpl utenteService;

	@GetMapping("/prova")
	public String prova() {
		return "prova";
	}

	@GetMapping("/list")
	public List<Utente> list() {
		return this.utenteService.list();
	}

}
