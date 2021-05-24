package com.io.develop.core.juego.servicio.impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.io.develop.core.juego.modelo.Bingo;
import com.io.develop.core.juego.repo.BingoRepo;
import com.io.develop.core.juego.servicio.BingoServicio;

@Service
public class BingoServicioImpl implements BingoServicio {

	@Autowired
	private BingoRepo bingoRepo;

	@Override
	@Transactional(readOnly = true)
	public Page<Bingo> findAll(Pageable pageable) {
		return bingoRepo.findAll(pageable);
	}

	@Override
	public List<Bingo> listadoGanadores(List<Integer> bingo) {
		List<Bingo>listado=(List<Bingo>) bingoRepo.findAll();
		List<Bingo>nListado=new ArrayList<>();
		int ganadores=0;
		System.out.println(listado.get(0).getListaNumeros().indexOf(null));
		for(int i=0;i<listado.size();i++) {
			int buscaNULL=listado.get(i).getListaNumeros().indexOf(null);
			if(buscaNULL!=-1)listado.get(i).getListaNumeros().set(buscaNULL, 0);  
				if(equalLists(bingo, listado.get(i).getListaNumeros()) && ganadores < 101) {
				System.out.println(ganadores);
				ganadores++;
				nListado.add(listado.get(i));
			}else {
				break;
			}
		}			
		return nListado;
	}
	public  boolean equalLists(List<Integer> a, List<Integer> b){     
	    if ((a.size() != b.size()) || (a == null && b!= null) || (a != null && b== null)){
	        return false;
	    }

	    if (a == null && b == null) return true;
	    Collections.sort(a);
	    Collections.sort(b);      
	    return a.equals(b);
	}
}
