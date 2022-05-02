package com.shopz.dto;

import com.shopz.entities.Usuario;

public class JwtResponse {

	private String cpf;
	private String email;
	private String password;
	private String token;
	
	public JwtResponse(Usuario usuario, String token) {
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
		this.token = token;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getToken() {
		return token;
	}
}
