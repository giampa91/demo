/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Utente;

/**
 *
 * @author org2
 */
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    
	
    @Query("select utente from Utente as utente")
    public List<Utente> list();
    
    @Query("SELECT utente FROM Utente utente WHERE utente.utenteUsername = :username")
    public Utente findByUtenteUsername(String username);
    
    
    
    
    
}
