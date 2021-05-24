package com.io.develop.core.seguridad.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.io.develop.core.seguridad.enums.RolNombre;
import com.sun.istack.NotNull;

@Entity
@Table(name="bingo_rol")
public class RolBingo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private int id;
	
	@NotNull
	@Column(name="name")
	private String nombre;
	
	@NotNull
	@Column(name="status")
	private String estado;
	
	@Column(name="created_at")
	private LocalDate creado_en;
	
	@Column(name="created_by")
	private String creado_por;
	
	@Column(name="last_updated_at")
	private String ultima_actua_en;
	
	@Column(name="last_updated_by")
	private String ultima_actua_por;
	
	@Column(name="deleted_at")
	private String eliminado_en;
	
	@Column(name="deleted_by")
	private String eliminado_por;
	
	@Column(name="readonly")
	private String lectura;
	
	@Column(name="bingo_rol_by_rol_id_rol_id")
	private String bingo_id;

	public RolBingo(String nombre, String estado) {
		this.nombre = nombre;
		this.estado = estado;
	}

	public RolBingo() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getCreado_en() {
		return creado_en;
	}

	public void setCreado_en(LocalDate creado_en) {
		this.creado_en = creado_en;
	}

	public String getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(String creado_por) {
		this.creado_por = creado_por;
	}

	public String getUltima_actua_en() {
		return ultima_actua_en;
	}

	public void setUltima_actua_en(String ultima_actua_en) {
		this.ultima_actua_en = ultima_actua_en;
	}

	public String getUltima_actua_por() {
		return ultima_actua_por;
	}

	public void setUltima_actua_por(String ultima_actua_por) {
		this.ultima_actua_por = ultima_actua_por;
	}

	public String getEliminado_en() {
		return eliminado_en;
	}

	public void setEliminado_en(String eliminado_en) {
		this.eliminado_en = eliminado_en;
	}

	public String getEliminado_por() {
		return eliminado_por;
	}

	public void setEliminado_por(String eliminado_por) {
		this.eliminado_por = eliminado_por;
	}

	public String getLectura() {
		return lectura;
	}

	public void setLectura(String lectura) {
		this.lectura = lectura;
	}

	public String getBingo_id() {
		return bingo_id;
	}

	public void setBingo_id(String bingo_id) {
		this.bingo_id = bingo_id;
	}	
	
}
