package com.shopz.dto;

public class CreateUsuarioRequest {

	private String cpf;
	private String email;
	private String password;

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
