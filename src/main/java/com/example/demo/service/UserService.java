package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Utente;
import com.example.demo.model.MyUserDetails;


@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UtenteServiceImpl utenteServiceImpl;

	@Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Utente user = utenteServiceImpl.findByUtenteUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
    
    
}