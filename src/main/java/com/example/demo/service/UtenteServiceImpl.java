/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UtenteRepository;
import com.example.demo.entity.Utente;

/**
 *
 * @author org2
 */
@Service
public class UtenteServiceImpl {

	@Autowired
	UtenteRepository utenteRepository;
	
	public List<Utente> list(){
		return this.utenteRepository.list();
	}
	
	public Utente findByUtenteUsername(String username) {
		return this.utenteRepository.findByUtenteUsername(username);
	}

}
