package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UtenteRepository;
import com.example.demo.entity.Utente;
import com.example.demo.model.AuthenticationRequest;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.service.UserService;
import com.example.demo.service.UtenteService;
import com.example.demo.service.UtenteServiceImpl;
import com.example.demo.util.JwtTokenUtil;

@RestController
public class SecurityRestController {

	@Autowired
	private UtenteServiceImpl utenteService;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest jwtRequest) throws Exception {

		// si fa autenticazione
		try {

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					jwtRequest.getUsername(), jwtRequest.getPassword());

			this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		} catch (Exception e) {
			throw new Exception("bad credentials", e);
		}

		// creo userDetail
		UserDetails userDetails = this.userService.loadUserByUsername(jwtRequest.getUsername());

		// genero token attraverso userDetails
		String token = this.jwtTokenUtil.generateToken(userDetails);

		// restituisco la response
		return new AuthenticationResponse(token);

	}

}
