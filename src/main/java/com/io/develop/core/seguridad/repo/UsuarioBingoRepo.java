package com.io.develop.core.seguridad.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.io.develop.core.seguridad.modelo.UsuarioBingo;

@Repository
public interface UsuarioBingoRepo extends JpaRepository<UsuarioBingo, Integer> {
	
	Optional<UsuarioBingo> findByUsuario(String usuario);
	boolean existsByUsuario(String usuario);
	
}
