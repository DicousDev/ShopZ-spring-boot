package com.shopz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopz.entities.Produto;
import com.shopz.services.ProdutoService;

@RestController
@RequestMapping(value = "/camisetas")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public List<Produto> findProdutosAll() {
		return service.findProdutosAll();
	}
}
