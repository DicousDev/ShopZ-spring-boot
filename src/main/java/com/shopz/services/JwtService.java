package com.shopz.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopz.dto.JwtRequest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	@Value("${spring.jwt.secretKey}")
	private String secretKey;
	
	@Value("${spring.jwt.expiration}")
	private String expiration;
	
	public String generateToken(JwtRequest user) {
		long expiration = Long.valueOf(this.expiration);
		LocalDateTime timeExpiration = LocalDateTime.now().plusMinutes(expiration);
		Instant instant = timeExpiration.atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		
		Map<String, Object> claims = new HashMap<>();
		claims.put("Email", user.getEmail());
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(user.getEmail())
				.setExpiration(date)
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
}
