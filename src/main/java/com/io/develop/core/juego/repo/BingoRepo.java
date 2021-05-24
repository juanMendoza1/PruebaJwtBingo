package com.io.develop.core.juego.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.io.develop.core.juego.modelo.Bingo;

@Repository
public interface BingoRepo extends PagingAndSortingRepository<Bingo, Integer>{
	
}
