package com.io.develop.core.seguridad.servicio;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.develop.core.seguridad.modelo.UsuarioBingo;
import com.io.develop.core.seguridad.repo.UsuarioBingoRepo;

@Service
@Transactional
public class UsuarioBingoServicio {

	@Autowired
	UsuarioBingoRepo usuBingoRepo;
	
	public Optional<UsuarioBingo>getByUsuario(String usuario){
		return usuBingoRepo.findByUsuario(usuario);
	}
	
	public boolean existsByUsuario(String usuario) {
		return usuBingoRepo.existsByUsuario(usuario);
	}
	
	public void save(UsuarioBingo usuario) {
		usuBingoRepo.save(usuario);
	}
	
}
