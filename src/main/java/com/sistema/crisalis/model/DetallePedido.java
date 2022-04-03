package com.sistema.crisalis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallePedido")
public class DetallePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String nombre;
	private Double precio;
	private Double total;
	
	@OneToOne
	private Pedido pedido; //Un pedido tiene su detalle
	
	/*En el detalle del pedido hay productos y servicios.
	*Es una relacion unidireccional porque no neceistamos 
	* saber en producto/serviico el detalle del pedido.
	* Solo lo vemos desde el detalle del pedido
	* */
	
	@ManyToOne
	private Producto producto;
	
	@ManyToOne
	private Servicio servicio;
	

	public DetallePedido() {
	}

	public DetallePedido(int id, String nombre, Double precio, Double total) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.total = total;
	}

	public DetallePedido(int id, String nombre, Double precio, Double total, Pedido pedido) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.total = total;
		this.pedido = pedido;
	}
	
	public DetallePedido(int id, String nombre, Double precio, Double total, Pedido pedido, Producto producto,
			Servicio servicio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.total = total;
		this.pedido = pedido;
		this.producto = producto;
		this.servicio = servicio;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public Double getTotal() {
		return total;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", total=" + total
				+ ", pedido=" + pedido + ", producto=" + producto + ", servicio=" + servicio + "]";
	}

}
