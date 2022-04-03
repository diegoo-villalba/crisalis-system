package com.sistema.crisalis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String nombre;
	private Double precio;
	
	@ManyToOne //Mapeo con la clase Cliente con visibilidad de ambos lados
	private Cliente cliente; //Relacion muchos a uno

	public Producto() {
	}

	public Producto(Integer id, String nombre, Double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto(Integer id, String nombre, Double precio, Cliente cliente) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cliente=" + cliente + "]";
	}

}
