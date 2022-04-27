package com.shopz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopz.entities.Produto;
import com.shopz.services.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/camisetas")
@Api(value = "Camisetas EndPoint API")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@ApiOperation(value = "Mostra lista de camisetas")
	@GetMapping
	public List<Produto> findProdutosAll() {
		return service.findProdutosAll();
	}
}
