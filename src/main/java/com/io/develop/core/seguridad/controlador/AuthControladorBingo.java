package com.io.develop.core.seguridad.controlador;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.develop.core.seguridad.dto.JwtDtoBingo;
import com.io.develop.core.seguridad.dto.LoginUsuarioBingo;
import com.io.develop.core.seguridad.dto.NuevoUsuarioBingo;
import com.io.develop.core.seguridad.enums.RolNombre;
import com.io.develop.core.seguridad.jwt.JwtProviderBingo;
import com.io.develop.core.seguridad.modelo.RolBingo;
import com.io.develop.core.seguridad.modelo.UsuarioBingo;
import com.io.develop.core.seguridad.servicio.RolBingoServicio;
import com.io.develop.core.seguridad.servicio.UsuarioBingoServicio;
import com.io.develop.core.util.Mensaje;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthControladorBingo {
	
	private final static Logger log=LoggerFactory.getLogger(AuthControladorBingo.class);
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioBingoServicio usuarioBingoServicio;
	
	@Autowired
	RolBingoServicio rolBingoServicio;
	
	@Autowired
	JwtProviderBingo jwtProvider;
	
	@PostMapping("/nuevo")
	public ResponseEntity<?>nuevo(@RequestBody NuevoUsuarioBingo nuevoUsuarioBingo,BindingResult bindingResult){
		if(bindingResult.hasErrors()) 
			return new ResponseEntity<>(new Mensaje("Hay campos requeridos"),HttpStatus.BAD_REQUEST);
		if(usuarioBingoServicio.existsByUsuario(nuevoUsuarioBingo.getUsuario()))
			return new ResponseEntity<>(new Mensaje("Usuario ya existe"),HttpStatus.BAD_REQUEST);
		
		UsuarioBingo usuarioBingo=
				new UsuarioBingo(nuevoUsuarioBingo.getNombre(),nuevoUsuarioBingo.getApellido(),
						nuevoUsuarioBingo.getUsuario(),passwordEncoder.encode(nuevoUsuarioBingo.getPassword()),
						nuevoUsuarioBingo.getRol_id(),nuevoUsuarioBingo.getEstado(),nuevoUsuarioBingo.getCreado_en(),
						nuevoUsuarioBingo.getCreado_por());
		Set<RolBingo>roles=new HashSet<>();
		//roles.add(rolBingoServicio.getByRolBingo(RolNombre.ROL_USUARIO).get());
		roles.add(rolBingoServicio.getByRolBingoId(3).get());
		
		if(nuevoUsuarioBingo.getRoles().contains("admin"))
			roles.add(rolBingoServicio.getByRolBingoId(2).get());
		
		usuarioBingo.setRoles(roles);
		usuarioBingoServicio.save(usuarioBingo);
		return new ResponseEntity<>("Usuario Creado Exitosamente",HttpStatus.CREATED);		
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDtoBingo>login(@RequestBody LoginUsuarioBingo loginUsuarioBingo,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			log.error("respuesta con error");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
		Authentication authentication=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuarioBingo.getUsuario(),loginUsuarioBingo.getPassword()));							
		SecurityContextHolder.getContext().setAuthentication(authentication);	
		String jwt=jwtProvider.generadorTokens(authentication);
		UserDetails userDetails=(UserDetails) authentication.getPrincipal();
		JwtDtoBingo jwtDtoBingo=new JwtDtoBingo(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity<>(jwtDtoBingo,HttpStatus.OK);		
	}
	

}
