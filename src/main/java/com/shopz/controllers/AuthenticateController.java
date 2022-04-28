package com.shopz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopz.dto.CreateUsuarioRequest;
import com.shopz.dto.CreateUsuarioResponse;
import com.shopz.services.AuthenticateService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/authenticate")
public class AuthenticateController {

	@Autowired
	private AuthenticateService service;
	
	@ApiOperation("Cria um novo usuário")
	@PostMapping
	public CreateUsuarioResponse create(@RequestBody CreateUsuarioRequest request) {
		return service.create(request);
	}
}
