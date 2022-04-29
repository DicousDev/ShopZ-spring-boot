package com.shopz.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.br.CPF;

import com.shopz.dto.CreateUsuarioRequest;

@Entity
@Table(name = "tb_user")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CPF
	private String cpf;
	
	@Email
	private String email;
	private String password;
	
	@ManyToMany
	@Fetch(FetchMode.JOIN)
	private List<Produto> produtos = new ArrayList<>();
	
	public Usuario() {
		
	}
	
	public Usuario(CreateUsuarioRequest usuario) {
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
	}
	
	public void insertProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public Long getId() {
		return id;
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
	
	public List<Produto> getProdutos() {
		return produtos;
	}
}
