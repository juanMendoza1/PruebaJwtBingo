package com.io.develop.core.seguridad.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.io.develop.core.seguridad.servicio.UserDetailServicioBingoImpl;

public class JwtTokenFilterBingo extends OncePerRequestFilter{
	
	private final static Logger log=LoggerFactory.getLogger(JwtTokenFilterBingo.class);

	@Autowired
	JwtProviderBingo jwtProviderBingo;
	
	@Autowired
	UserDetailServicioBingoImpl userDetailServicioBingoImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token=getToken(request);
			if(token != null && jwtProviderBingo.validateToken(token)) {
				String nombreUsuario=jwtProviderBingo.getnombreUsuarioFromToken(token);
				UserDetails details=userDetailServicioBingoImpl.loadUserByUsername(nombreUsuario);				
				UsernamePasswordAuthenticationToken auth=
						new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			log.error("fallo en el metodo Dofilter - "+e.getMessage());
		}
		 filterChain.doFilter(request, response);	
		
	}
	private String getToken(HttpServletRequest req) {
		String header=req.getHeader("Authorization");
		if(header!=null && header.startsWith("Bearer")) {
			return header.replace("Bearer", "");			
		}
		return null;
	}


}
