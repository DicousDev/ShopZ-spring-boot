package com.shopz.dto;

import com.shopz.entities.Usuario;

public class CreateUsuarioResponse {

	private String cpf;
	private String email;
	private String password;
	
	public CreateUsuarioResponse(Usuario usuario) {
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
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
}
