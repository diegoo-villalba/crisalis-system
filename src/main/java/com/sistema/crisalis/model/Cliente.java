package com.sistema.crisalis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String nombre;
	private String apellido;
	private String dni;
	private String tipo;

	@OneToMany(mappedBy = "cliente") // Mapeamos con el atributo de la clase Producto
	private List<Producto> productos; // Relacion uno a muchos

	@OneToMany(mappedBy = "cliente")
	private List<Servicio> servicios; // Relacion uno a muchos

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedido; // Lista de pedidos del usuario

	public Cliente() {
	}

	public Cliente(Integer id, String nombre, String apellido, String dni, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tipo = tipo;
	}

	public Cliente(Integer id, String nombre, String apellido, String dni, String tipo, List<Producto> productos,
			List<Servicio> servicios, List<Pedido> pedido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tipo = tipo;
		this.productos = productos;
		this.servicios = servicios;
		this.pedido = pedido;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public String getTipo() {
		return tipo;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", tipo=" + tipo
				+ ", productos=" + productos + ", servicios=" + servicios + ", pedido=" + pedido + "]";
	}

}
