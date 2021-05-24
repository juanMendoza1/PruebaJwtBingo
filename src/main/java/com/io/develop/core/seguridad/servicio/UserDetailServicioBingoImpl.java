package com.io.develop.core.seguridad.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.io.develop.core.seguridad.jwt.JwtTokenFilterBingo;
import com.io.develop.core.seguridad.modelo.UsuarioBingo;
import com.io.develop.core.seguridad.modelo.UsuarioPrincipalBingo;

@Service
public class UserDetailServicioBingoImpl implements UserDetailsService {
	
	private final static Logger log=LoggerFactory.getLogger(UserDetailServicioBingoImpl.class);
	
	@Autowired
	UsuarioBingoServicio usuarioBingoServicio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioBingo usuario=usuarioBingoServicio.getByUsuario(username).get();
		return UsuarioPrincipalBingo.build(usuario);
	}

	
}
