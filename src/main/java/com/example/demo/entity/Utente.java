package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.*;

@Entity(name="Utente")
public class Utente {
	
	@Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "utenteusername")
	private String utenteUsername;
	
	@Basic(optional = false)
	@Column(name = "utenteemail")
	private String utenteEmail;
	
	@Basic(optional = false)
	@Column(name = "utentepassword")
	private String utentePassword;
	
	@Column(name = "roles")
	private String role;
	
	/*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<Role> roles = new HashSet<>(); */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUtenteUsername() {
		return utenteUsername;
	}

	public void setUtenteUsername(String utenteUsername) {
		this.utenteUsername = utenteUsername;
	}

	public String getUtenteEmail() {
		return utenteEmail;
	}

	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

	public String getUtentePassword() {
		return utentePassword;
	}

	public void setUtentePassword(String utentePassword) {
		this.utentePassword = utentePassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	

}
