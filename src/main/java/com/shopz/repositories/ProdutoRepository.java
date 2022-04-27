package com.shopz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopz.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
