package com.io.develop.core.seguridad.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.develop.core.seguridad.enums.RolNombre;
import com.io.develop.core.seguridad.modelo.RolBingo;
import com.io.develop.core.seguridad.repo.RolBingoRepo;

@Service
public class RolBingoServicio {

	@Autowired
	RolBingoRepo rolBingoRepo;
	
	public Optional<RolBingo>getByRolBingo(RolNombre rolNombre){
		return rolBingoRepo.findByNombre(rolNombre);
	}
	
	public Optional<RolBingo>getByRolBingoId(int idRolBingo){
		return rolBingoRepo.findById(idRolBingo);
	}
	
	public void save(RolBingo rolBingo) {
		rolBingoRepo.save(rolBingo);
	}
	
	
}
