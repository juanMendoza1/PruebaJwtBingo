package com.io.develop.core.seguridad.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.io.develop.core.seguridad.enums.RolNombre;
import com.io.develop.core.seguridad.modelo.RolBingo;

@Repository
public interface RolBingoRepo extends JpaRepository<RolBingo, Integer>{	
	Optional<RolBingo> findById(int idRolBingo);	
	Optional<RolBingo> findByNombre(RolNombre rolNombre);
}
