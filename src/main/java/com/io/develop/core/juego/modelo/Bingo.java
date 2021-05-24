package com.io.develop.core.juego.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.array.ListArrayType;

@Entity
@TypeDef(name = "list-array",
	    typeClass = ListArrayType.class
	)
@Table(name="bingo_param_board",schema = "public")
public class Bingo {		
	@Id
	@Column(name="board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int Id;
	
	@Type(type = "list-array")
	@Column(name="board_numbers",columnDefinition = "integer[]")
	private List<Integer> listaNumeros;
	
	@Column(name="status")
	private String estado;
	
	@Column(name="created_by")
	private String creado_por;
	
	@Column(name="last_updated_at")
	private LocalDate ultima_actua_en;
	
	@Column(name="last_updated_by")
	private String ultima_actua_por;
	
	@Column(name="deleted_at")
	private LocalDate eliminado_en;
	
	@Column(name="deleted_by")
	private String eliminado_por;
	
	@Column(name="created_at")
	private LocalDate creado_en;
	
	@Column(name="sensor_values")
	private Integer[] valores;

	public Bingo(List<Integer> listaNumeros, String estado) {
		super();
		this.listaNumeros = listaNumeros;
		this.estado = estado;
		this.creado_por=null;
		this.ultima_actua_en=null;
		this.ultima_actua_por=null;
		this.eliminado_en=null;
		this.eliminado_por=null;
		this.creado_en=null;
		this.valores=null;
	}	

	public Bingo() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public List<Integer> getListaNumeros() {
		return listaNumeros;
	}

	public void setListaNumeros(List<Integer> listaNumeros) {
		this.listaNumeros = listaNumeros;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(String creado_por) {
		this.creado_por = creado_por;
	}

	public LocalDate getUltima_actua_en() {
		return ultima_actua_en;
	}

	public void setUltima_actua_en(LocalDate ultima_actua_en) {
		this.ultima_actua_en = ultima_actua_en;
	}

	public String getUltima_actua_por() {
		return ultima_actua_por;
	}

	public void setUltima_actua_por(String ultima_actua_por) {
		this.ultima_actua_por = ultima_actua_por;
	}

	public LocalDate getEliminado_en() {
		return eliminado_en;
	}

	public void setEliminado_en(LocalDate eliminado_en) {
		this.eliminado_en = eliminado_en;
	}

	public String getEliminado_por() {
		return eliminado_por;
	}

	public void setEliminado_por(String eliminado_por) {
		this.eliminado_por = eliminado_por;
	}

	public LocalDate getCreado_en() {
		return creado_en;
	}

	public void setCreado_en(LocalDate creado_en) {
		this.creado_en = creado_en;
	}

	public Integer[] getValores() {
		return valores;
	}

	public void setValores(Integer[] valores) {
		this.valores = valores;
	}	
	

}
