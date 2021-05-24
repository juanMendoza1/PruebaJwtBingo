package com.io.develop.core.seguridad.dto;

import javax.persistence.Column;

import com.sun.istack.NotNull;

public class LoginUsuarioBingo {
	@NotNull
	@Column(name="username")
	private String usuario;
	
	@NotNull
	@Column(name="password")
	private String password;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
