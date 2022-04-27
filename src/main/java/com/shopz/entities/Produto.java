package com.shopz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Double precoAtual;
	private Double parcelas;
	
	public Produto() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public Double getPrecoAtual() {
		return precoAtual;
	}

	public Double getParcelas() {
		return parcelas;
	}
}
