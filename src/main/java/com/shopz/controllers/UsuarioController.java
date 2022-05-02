package com.shopz.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopz.dto.ChangePasswordRequest;
import com.shopz.entities.Usuario;
import com.shopz.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public Usuario getUsuarioLogado(HttpServletRequest request) {
		return service.getUsuarioLogado(request);
	}
	
	@GetMapping
	public void changePassword(HttpServletRequest request, ChangePasswordRequest usuario) {
		
	}
	
	@PostMapping(value = "/produtos/{idProduto}")
	public Usuario insertProduto(HttpServletRequest request, @PathVariable Long idProduto) {
		return service.insertProdutoById(request, idProduto);
	}
	
	@DeleteMapping(value = "/produtos/{idProduto}")
	public Usuario removeProduto(HttpServletRequest request, @PathVariable Long idProduto) {
		return service.removeProdutoById(request, idProduto);
	}
}
