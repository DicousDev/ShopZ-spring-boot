package com.shopz.dto;

public class JwtRequest {

	private String cpf;
	private String email;
	private String password;
	
	public JwtRequest(String cpf, String email, String password) {
		this.cpf = cpf;
		this.email = email;
		this.password = password;
	}
}
