package com.io.develop.core.seguridad.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

public class NuevoUsuarioBingo {
	
	private Set<String>roles=new HashSet<>();
	
	@NotNull
	@Column(name="names")
	private String nombre;
	
	@NotNull
	@Column(name="last_name")
	private String apellido;
	
	@NotNull
	@Column(name="username")
	private String usuario;
	
	@Column(name="img_url")
	private String img;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotNull
	@Column(name="rol_id")
	private int rol_id;
	
	@NotNull
	@Column(name="status")
	private String estado;
		
	@Column(name="expired")
	private boolean caduco;
	
	@Column(name="locked")
	private boolean bloqueado;
	
	@Column(name="credrencials_expired")
	private boolean credenciales_caducado;
	
	@Column(name="phone")
	private String telefono;
	
	@Column(name="position")
	private String posicion;
	
	@Column(name="created_at")
	private LocalDate creado_en;
	
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
	
	@Column(name="cedula")
	private String cedula;
	
	@Column(name="customer_id")
	private Integer cliente_id;
	
	@Column(name="maxrecharge")
	private Integer max_recarga;
	
	@Column(name="nacimiento")
	private LocalDate nacimiento;
	
	@Column(name="preregister")
	private boolean pre_registro;

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRol_id() {
		return rol_id;
	}

	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isCaduco() {
		return caduco;
	}

	public void setCaduco(boolean caduco) {
		this.caduco = caduco;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public boolean isCredenciales_caducado() {
		return credenciales_caducado;
	}

	public void setCredenciales_caducado(boolean credenciales_caducado) {
		this.credenciales_caducado = credenciales_caducado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Integer getMax_recarga() {
		return max_recarga;
	}

	public void setMax_recarga(Integer max_recarga) {
		this.max_recarga = max_recarga;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public boolean isPre_registro() {
		return pre_registro;
	}

	public void setPre_registro(boolean pre_registro) {
		this.pre_registro = pre_registro;
	}
	
	

}
