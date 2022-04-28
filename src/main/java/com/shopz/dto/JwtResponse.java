package com.shopz.dto;

public class JwtResponse {

	private String cpf;
	private String email;
	private String password;
	private String token;
	
	public JwtResponse(String cpf, String email, String password, String token) {
		this.cpf = cpf;
		this.email = email;
		this.password = password;
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
