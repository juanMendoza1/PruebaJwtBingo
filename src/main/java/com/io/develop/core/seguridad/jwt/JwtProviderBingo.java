package com.io.develop.core.seguridad.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.io.develop.core.seguridad.modelo.UsuarioPrincipalBingo;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProviderBingo {

private final static Logger log=LoggerFactory.getLogger(JwtProviderBingo.class);
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration;
	
	public String generadorTokens(Authentication authentication) {
		UsuarioPrincipalBingo usuarioPrincipalBingo=(UsuarioPrincipalBingo) authentication.getPrincipal();
		return Jwts.builder().setSubject(usuarioPrincipalBingo.getUsername())
		.setIssuedAt(new Date())
		.setExpiration(new Date(new Date().getTime()+expiration * 1000))
		.signWith(SignatureAlgorithm.HS512, secret)
		.compact();
	}
	
	public String getnombreUsuarioFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		}catch(MalformedJwtException e) {
			log.error("token mal formado");
		}catch(UnsupportedJwtException e) {
			log.error("token no soportado");
		}catch(ExpiredJwtException e) {
			log.error("token expirado");
		}catch(IllegalArgumentException e) {
			log.error("token vacio");
		}catch(SignatureException e) {
			log.error("fallo firma");
		}
		return false;
	}
}
