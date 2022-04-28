package com.shopz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shopz.dto.CreateUsuarioRequest;
import com.shopz.dto.CreateUsuarioResponse;
import com.shopz.dto.JwtRequest;
import com.shopz.dto.JwtResponse;
import com.shopz.services.AuthenticateService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/authenticate")
public class AuthenticateController {

	@Autowired
	private AuthenticateService service;
	
	@ApiOperation("Cria um novo usuário")
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public CreateUsuarioResponse create(@RequestBody CreateUsuarioRequest request) {
		return service.create(request);
	}
	
	@ApiOperation("Login de usuário")
	@PostMapping
	public JwtResponse login(@RequestBody JwtRequest request) {
		return service.authenticate(request);
	}
}
