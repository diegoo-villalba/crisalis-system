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
	private double precio;
	private double total;

	@OneToOne
	private Pedido pedido; // Un pedido tiene su detalle

	/*
	 * En el detalle del pedido hay productos y servicios. Es una relacion
	 * unidireccional porque no neceistamos saber en producto/serviico el detalle
	 * del pedido. Solo lo vemos desde el detalle del pedido
	 */

	@ManyToOne
	private ItemVenta item;

	public DetallePedido() {
	}

	public DetallePedido(int id, String nombre, double precio, double total) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.total = total;
	}

	public DetallePedido(int id, String nombre, double precio, double total, Pedido pedido) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.total = total;
		this.pedido = pedido;
	}

	public DetallePedido(int id, String nombre, double precio, double total, Pedido pedido, ItemVenta item) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.total = total;
		this.pedido = pedido;
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public double getTotal() {
		return total;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ItemVenta getItem() {
		return item;
	}

	public void setItem(ItemVenta item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", total=" + total
				+ ", pedido=" + pedido + ", item=" + item + "]";
	}

}
