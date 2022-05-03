package com.shopz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> create(@RequestBody CreateUsuarioRequest request) {
		
		try {
			CreateUsuarioResponse response = service.create(request);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@ApiOperation("Login de usuário")
	@PostMapping
	public ResponseEntity<?> login(@RequestBody JwtRequest request) {
		
		try {
			JwtResponse response = service.authenticate(request);
			return ResponseEntity.status(HttpStatus.OK).body(response);		
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}
