package com.shopz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopz.dto.CreateUsuarioRequest;
import com.shopz.dto.CreateUsuarioResponse;
import com.shopz.entities.Usuario;
import com.shopz.repositories.UsuarioRepository;

@Service
public class AuthenticateService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public CreateUsuarioResponse create(CreateUsuarioRequest request) {
		request.setPassword(passwordEncoder.encode(request.getPassword()));
		Usuario usuario = new Usuario(request);
		Usuario salvo = repository.save(usuario);
		return new CreateUsuarioResponse(salvo);
	}
}