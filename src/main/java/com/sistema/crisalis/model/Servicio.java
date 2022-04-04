package com.sistema.crisalis.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="servicio")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	private String nombre;
	private Double costo;
	private boolean esEspecial;


	public Servicio() {
	}

	public Servicio(Integer id, String nombre, Double costo, LocalDate fechaCompra) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
	}

	public Servicio(Integer id, String nombre, Double costo, LocalDate fechaCompra, boolean esEspecial) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.esEspecial = esEspecial;
	}
	
	public Servicio(Integer id, String nombre, Double costo, LocalDate fechaCompra, boolean esEspecial,
			Cliente cliente) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.esEspecial = esEspecial;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getCosto() {
		return costo;
	}

	public boolean isEsEspecial() {
		return esEspecial;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}


	public void setEsEspecial(boolean esEspecial) {
		this.esEspecial = esEspecial;
	}
	

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", costo=" + costo
				+ ", esEspecial=" + esEspecial + "]";
	}
	
	
}
