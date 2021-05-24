package com.io.develop.core.seguridad.modelo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipalBingo implements UserDetails{
	
	private final static Logger log=LoggerFactory.getLogger(UsuarioPrincipalBingo.class);
	
	private String usuario;
	private String password;
	private Collection<? extends GrantedAuthority>authorities;	
	
	public UsuarioPrincipalBingo(String usuario, String password, Collection<? extends GrantedAuthority> authorities) {
		this.usuario = usuario;
		this.password = password;
		this.authorities = authorities;
	}

	public static UsuarioPrincipalBingo build(UsuarioBingo usuario) {			
		List<GrantedAuthority>authorities=usuario.getRoles().stream().map(rol -> 
		new SimpleGrantedAuthority(rol.getNombre()))
				.collect(Collectors.toList());
		return new UsuarioPrincipalBingo(usuario.getUsuario(),usuario.getPassword(),authorities);		
	}	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
