package com.io.develop.core.juego.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bingo_param_group_figure")
public class GroupFigura {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="group_figure_id")
	private int id;
	
	@Column(name="group_name")
	private String grupo_nombre;

	@Column(name="opportunity")
	private int oportunidad;	

	@Column(name="status")
	private String estado;	

	@Column(name="created_by")
	private Integer creado_por;	

	@Column(name="last_updated_at")
	private LocalDate ultima_actua_en;
	
	@Column(name="last_updated_by")
	private Integer ultima_actua_por;

	@Column(name="deleted_at")
	private LocalDate eliminado_en;
	
	@Column(name="deleted_by")
	private Integer eliminado_por;
	
	@Column(name="created_at")
	private LocalDate creado_en;	

	@Column(name="used")
	private boolean usado;	

	@Column(name="close_at")
	private Integer cerrado_en;	

	@Column(name="select_figure")
	private boolean seleccion_figura;	
	
	public GroupFigura() {		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrupo_nombre() {
		return grupo_nombre;
	}

	public void setGrupo_nombre(String grupo_nombre) {
		this.grupo_nombre = grupo_nombre;
	}

	public int getOportunidad() {
		return oportunidad;
	}

	public void setOportunidad(int oportunidad) {
		this.oportunidad = oportunidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(Integer creado_por) {
		this.creado_por = creado_por;
	}

	public LocalDate getUltima_actua_en() {
		return ultima_actua_en;
	}

	public void setUltima_actua_en(LocalDate ultima_actua_en) {
		this.ultima_actua_en = ultima_actua_en;
	}

	public Integer getUltima_actua_por() {
		return ultima_actua_por;
	}

	public void setUltima_actua_por(Integer ultima_actua_por) {
		this.ultima_actua_por = ultima_actua_por;
	}

	public LocalDate getEliminado_en() {
		return eliminado_en;
	}

	public void setEliminado_en(LocalDate eliminado_en) {
		this.eliminado_en = eliminado_en;
	}

	public Integer getEliminado_por() {
		return eliminado_por;
	}

	public void setEliminado_por(Integer eliminado_por) {
		this.eliminado_por = eliminado_por;
	}

	public LocalDate getCreado_en() {
		return creado_en;
	}

	public void setCreado_en(LocalDate creado_en) {
		this.creado_en = creado_en;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public Integer getCerrado_en() {
		return cerrado_en;
	}

	public void setCerrado_en(Integer cerrado_en) {
		this.cerrado_en = cerrado_en;
	}

	public boolean isSeleccion_figura() {
		return seleccion_figura;
	}

	public void setSeleccion_figura(boolean seleccion_figura) {
		this.seleccion_figura = seleccion_figura;
	}
	
	
	
	
}
