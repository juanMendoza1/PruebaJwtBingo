package com.io.develop.core.juego.servicio;

import com.io.develop.core.juego.modelo.Figura;
import com.io.develop.core.juego.modelo.GroupFigura;

public interface FiguraServicio {
	public Figura getFigura(Integer id);
	public void save(Figura figura);
}
