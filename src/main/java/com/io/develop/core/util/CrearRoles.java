package com.io.develop.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.io.develop.core.seguridad.enums.RolNombre;
import com.io.develop.core.seguridad.servicio.RolBingoServicio;


@Component
public class CrearRoles implements CommandLineRunner {

	@Autowired
	RolBingoServicio rolBingoServicio;	
	
	@Override
	public void run(String... args) throws Exception {
		/*Rol rolAdmin=new Rol(RolNombre.ROL_ADMIN);
		Rol rolUsuario=new Rol(RolNombre.ROL_USUARIO);
		rolServicio.save(rolUsuario);
		rolServicio.save(rolAdmin);*/
	}

}
