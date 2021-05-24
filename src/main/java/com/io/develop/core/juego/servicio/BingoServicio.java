package com.io.develop.core.juego.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.io.develop.core.juego.modelo.Bingo;

public interface BingoServicio {	
	public Page<Bingo>findAll(Pageable pageable);
	public List<Bingo>listadoGanadores(List<Integer>bingo);
}
