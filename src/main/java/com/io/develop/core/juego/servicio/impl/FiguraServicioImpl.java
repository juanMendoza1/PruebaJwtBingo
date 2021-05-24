package com.io.develop.core.juego.servicio.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.develop.core.juego.modelo.Figura;
import com.io.develop.core.juego.modelo.GroupFigura;
import com.io.develop.core.juego.repo.FiguraRepo;
import com.io.develop.core.juego.servicio.FiguraServicio;

@Service
public class FiguraServicioImpl implements FiguraServicio {

	@Autowired
	private FiguraRepo figuraRepo;
	
	@Override
	public Figura getFigura(Integer id) {
		// TODO Auto-generated method stub
		return figuraRepo.findById(id).get();
	}

	@Override
	public void save(Figura figura) {
		GroupFigura group=new GroupFigura();
		group.setGrupo_nombre("VACIO");
		int cont=0;
		for(int i=0;i<figura.getPosicion().size();i++) {
			if(figura.getPosicion().get(i)==true)cont+=1;
		}
		if(cont>15)group.setGrupo_nombre("LLENO");		
		figura.getPosicion().forEach(p->{System.out.println(p);});	
		
		figura.setCreado_en(LocalDate.now());
		figura.setCreado_por(15);
		group.setGrupo_nombre("LLENO");
		group.setEstado(figura.getEstado());
		group.setCreado_por(figura.getCreado_por());
		group.setOportunidad(1);
		group.setCreado_en(figura.getCreado_en());
		group.setUsado(true);
		group.setSeleccion_figura(true);		
		figura.setGroup_figura(group);
		figuraRepo.save(figura);
	}

}
