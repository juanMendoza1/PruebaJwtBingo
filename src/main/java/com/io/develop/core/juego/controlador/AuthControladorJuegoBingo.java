package com.io.develop.core.juego.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.develop.core.juego.modelo.Bingo;
import com.io.develop.core.juego.modelo.Figura;
import com.io.develop.core.juego.modelo.GroupFigura;
import com.io.develop.core.juego.repo.BingoRepo;
import com.io.develop.core.juego.servicio.impl.BingoServicioImpl;
import com.io.develop.core.juego.servicio.impl.FiguraServicioImpl;

@RestController
@RequestMapping("/juego")
public class AuthControladorJuegoBingo {
	
	@Autowired
	private BingoServicioImpl bingoServicio;
	
	@Autowired
	private FiguraServicioImpl figuraServicio;
	
	@GetMapping("/bingo/{pagina}")
	public Page<Bingo> bingo(@PathVariable Integer pagina){
		Pageable pageable=PageRequest.of(pagina, 100);		
		return bingoServicio.findAll(pageable);
	}
	
	@GetMapping("/figura/{figura}")
	public Figura figura(@PathVariable Integer figura){
		return figuraServicio.getFigura(figura);
	}
	
	@PutMapping("/nuevo")
	public void nuevo(@RequestBody Figura figura){
		figuraServicio.save(figura);		
	}
	
	@PostMapping("/bingo_ganador")
	public List<Bingo>ganadores(@RequestBody List<Integer> bingo){	
		return bingoServicio.listadoGanadores(bingo);
	}
	
}
