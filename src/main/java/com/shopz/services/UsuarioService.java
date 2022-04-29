package com.shopz.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopz.entities.Usuario;
import com.shopz.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private JwtService jwtService;

	public Usuario getUsuarioLogado(HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
		
		if(authorization != null && authorization.startsWith("Bearer")) {
			String token = authorization.split(" ")[1];
			
			if(jwtService.isTokenValid(token)) {
				Long id = Long.parseLong(jwtService.getClaims(token).get("usuarioId").toString());
				return repository.findById(id).get();
			}
		}
		
		return null;
	}
}
