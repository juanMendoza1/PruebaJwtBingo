package com.io.develop.core.juego.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.array.ListArrayType;

@Entity
@TypeDef(name = "list-array",
	    typeClass = ListArrayType.class
	)
@Table(name="bingo_param_figure")
public class Figura {
	@Id
	@Column(name="figure_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="group_figure_id")
	private GroupFigura group_figura;
	
	@Column(name="figure_name")
	private String nombre_figura;
	
	@Type(type = "list-array")
	@Column(name="positions_winner",columnDefinition = "boolean[]")
	private List<Boolean> posicion;
	
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

	public Figura() {
	}	
	
	public List<Boolean> getPosicion() {
		return posicion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GroupFigura getGroup_figura() {
		return group_figura;
	}

	public void setGroup_figura(GroupFigura group_figura) {
		this.group_figura = group_figura;
	}

	public String getNombre_figura() {
		return nombre_figura;
	}

	public void setNombre_figura(String nombre_figura) {
		this.nombre_figura = nombre_figura;
	}

	public List<Boolean> isPosicion() {
		return posicion;
	}

	public void setPosicion(List<Boolean> posicion) {
		this.posicion = posicion;
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
}
