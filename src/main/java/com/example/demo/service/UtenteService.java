package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Utente;

@Service
public interface UtenteService {

	public List<Utente> list();
	
	
	
}
