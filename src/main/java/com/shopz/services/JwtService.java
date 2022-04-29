package com.shopz.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopz.dto.JwtRequest;

import io.jsonwebtoken.Claims;
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
		claims.put("usuarioId", user.getId());
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(user.getEmail())
				.setExpiration(date)
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
	
	public Boolean isTokenValid(String token) {
		try {
			Claims claims = getClaims(token);
			Date expiration = claims.getExpiration();
			LocalDateTime expirationDate = expiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return !LocalDateTime.now().isAfter(expirationDate);
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public String objetLoginUsuario(String token) {
		return (String) getClaims(token).getSubject();
	}
	
	public Long getIdDoUsuarioLogado(String token) {
		return Long.parseLong(getClaim(token, "usuarioId"));
	}
	
	public String getTokenRequest(HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
		
		if(authorization != null && authorization.startsWith("Bearer")) {
			String token = authorization.split(" ")[1];
			
			if(isTokenValid(token)) {
				return token;
			}
		}
		
		throw new RuntimeException("Token inválido!");
	}
	
	private String getClaim(String token, String key) {
		return getClaims(token).get(key).toString();
	}
	
	private Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody();
	}
}
