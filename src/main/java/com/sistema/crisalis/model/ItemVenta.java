package com.sistema.crisalis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "itemVenta")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ItemVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	private String nombre;
	private Double costo;

	public ItemVenta() {

	}

	public ItemVenta(Integer id, String nombre, Double costo) {
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	

	public String getNombre() {
		return nombre;
	}

	public Double getCosto() {
		return costo;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ItemVenta [id=" + id + ", nombre=" + nombre + ", costo=" + costo + "]";
	}

}
