package com.sistema.crisalis.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private double total;
	private String numeroPedido;
	private Date fechaCreacion;
	private Date fechaRecibido;

	@ManyToOne
	private Cliente cliente; // Un cliente puede tener muchas ordenes

	@OneToMany(mappedBy = "pedido")
	private List<DetallePedido> detallePedido; //Un pedido tiene su detalle
	
	public Pedido() {
	}

	public Pedido(Integer id, double total, String numeroPedido, Date fechaCreacion, Date fechaRecibido) {
		this.id = id;
		this.total = total;
		this.numeroPedido = numeroPedido;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibido = fechaRecibido;
	}

	
	public Integer getId() {
		return id;
	}

	public double getTotal() {
		return total;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaRecibido() {
		return fechaRecibido;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", total=" + total + ", numeroPedido=" + numeroPedido + ", fechaCreacion="
				+ fechaCreacion + ", fechaRecibido=" + fechaRecibido + ", cliente=" + cliente + ", detallePedido="
				+ detallePedido + "]";
	}
	
	

}
