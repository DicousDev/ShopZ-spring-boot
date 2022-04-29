package com.shopz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopz.dto.CreateUsuarioRequest;
import com.shopz.dto.CreateUsuarioResponse;
import com.shopz.dto.JwtRequest;
import com.shopz.dto.JwtResponse;
import com.shopz.entities.Usuario;
import com.shopz.repositories.UsuarioRepository;

@Service
public class AuthenticateService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	public UserDetails loadUserByUsername(String email) {
		Usuario user = repository.findByEmail(email);
		return User.builder()
				.username(user.getEmail())
				.password(user.getPassword())
				.roles("USER")
				.build();
	}
	
	public CreateUsuarioResponse create(CreateUsuarioRequest request) {
		request.setPassword(passwordEncoder.encode(request.getPassword()));
		Usuario usuario = new Usuario(request);
		Usuario salvo = repository.save(usuario);
		return new CreateUsuarioResponse(salvo);
	}
	
	public JwtResponse authenticate(JwtRequest request) {
		UserDetails userDetails = loadUserByUsername(request.getEmail());
		boolean passwordValid = passwordEncoder.matches(request.getPassword(), userDetails.getPassword());
		
		if(!passwordValid) {
			throw new RuntimeException("Senha inválida!");
		}
		
		Usuario usuario = repository.findByEmail(request.getEmail());
		request.setId(usuario.getId());
		String token = jwtService.generateToken(request);
		return new JwtResponse(usuario.getCpf(), usuario.getEmail(), usuario.getPassword(), token);
	}
	

}