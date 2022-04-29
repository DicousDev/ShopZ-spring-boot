package com.shopz.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shopz.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
}
