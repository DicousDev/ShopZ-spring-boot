package com.shopz.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopz.dto.ChangePasswordRequest;
import com.shopz.entities.Usuario;
import com.shopz.exceptions.NotFoundRuntimeException;
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
	
	@PutMapping(value = "/password")
	public ResponseEntity<?> changePassword(HttpServletRequest request, @RequestBody ChangePasswordRequest body) {
		
		try {
			service.changePassword(request, body);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e); 
		}
	}
	
	@PostMapping(value = "/produtos/{idProduto}")
	public ResponseEntity<?> insertProduto(HttpServletRequest request, @PathVariable Long idProduto) {
		
		try {
			Usuario usuario = service.insertProdutoById(request, idProduto);
			return ResponseEntity.status(HttpStatus.OK).body(usuario); 
		}
		catch(NotFoundRuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e); 
		}
	}
	
	@DeleteMapping(value = "/produtos/{idProduto}")
	public ResponseEntity<?> removeProduto(HttpServletRequest request, @PathVariable Long idProduto) {
		
		try {
			Usuario usuario = service.removeProdutoById(request, idProduto);
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		}
		catch(NotFoundRuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}
	}
	
	@DeleteMapping(value = "/produtos")
	public Usuario removeTodosProdutos(HttpServletRequest request) {
		return service.removeProdutosAll(request);
	}
}
