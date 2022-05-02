package com.shopz.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopz.entities.Produto;
import com.shopz.entities.Usuario;
import com.shopz.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private ProdutoService produtoService;

	public Usuario getUsuarioLogado(HttpServletRequest request) {
		String token = jwtService.getTokenRequest(request);
		Long idUsuario = jwtService.getIdDoUsuarioLogado(token);
		return repository.findById(idUsuario).get();
	}
	
	public void changePassword(HttpServletRequest request) {
		Usuario usuarioLogado = getUsuarioLogado(request);
		
	}
	
	public Usuario insertProdutoById(HttpServletRequest request, Long idProduto) {
		Produto produto = produtoService.findProdutoById(idProduto);
		Usuario usuarioLogado = getUsuarioLogado(request);
		usuarioLogado.insertProduto(produto);
		return repository.save(usuarioLogado);
	}
	
	public Usuario removeProdutoById(HttpServletRequest request, Long idProduto) {
		Produto produto = produtoService.findProdutoById(idProduto);
		Usuario usuarioLogado = getUsuarioLogado(request);
		usuarioLogado.removeProduto(produto);
		return repository.save(usuarioLogado);
	}
}
