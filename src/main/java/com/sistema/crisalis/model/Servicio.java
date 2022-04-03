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
	private LocalDate fechaCompra;
	private boolean esEspecial;
	
	@ManyToOne //Mapeo con la clase Cliente con visibilidad de ambos lados
	private Cliente cliente; //Relacion muchos a uno

	public Servicio() {
	}

	public Servicio(Integer id, String nombre, Double costo, LocalDate fechaCompra) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.fechaCompra = fechaCompra;
	}

	public Servicio(Integer id, String nombre, Double costo, LocalDate fechaCompra, boolean esEspecial) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.fechaCompra = fechaCompra;
		this.esEspecial = esEspecial;
	}
	
	public Servicio(Integer id, String nombre, Double costo, LocalDate fechaCompra, boolean esEspecial,
			Cliente cliente) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.fechaCompra = fechaCompra;
		this.esEspecial = esEspecial;
		this.cliente = cliente;
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

	public LocalDate getFechaCompra() {
		return fechaCompra;
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

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public void setEsEspecial(boolean esEspecial) {
		this.esEspecial = esEspecial;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", fechaCompra=" + fechaCompra
				+ ", esEspecial=" + esEspecial + ", cliente=" + cliente + "]";
	}
	
	
}
