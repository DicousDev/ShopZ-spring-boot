package com.shopz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopz.entities.Produto;
import com.shopz.exceptions.NotFoundRuntimeException;
import com.shopz.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findProdutosAll() {
		return repository.findAll();
	}
	
	public Produto findProdutoById(Long idProduto) {
		Optional<Produto> produto = repository.findById(idProduto);
		
		if(produto.isEmpty()) {
			throw new NotFoundRuntimeException("Produto não encontrado");
		}
		
		return produto.get();
	}
}
