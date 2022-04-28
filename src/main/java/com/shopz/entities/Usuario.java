package com.shopz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shopz.dto.CreateUsuarioRequest;

@Entity
@Table(name = "tb_user")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String email;
	private String password;
	
	public Usuario() {
		
	}
	
	public Usuario(CreateUsuarioRequest usuario) {
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
