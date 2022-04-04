package com.sistema.crisalis.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private Double total;
	private String numeroPedido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaRecibido;

	@ManyToOne
	private Cliente cliente; // Un cliente puede tener muchas ordenes

	@OneToOne(mappedBy = "pedido")
	private DetallePedido detallePedido; //Un pedido tiene su detalle
	
	public Pedido() {
	}

	public Pedido(Double total, String numeroPedido, LocalDate fechaCreacion, LocalDate fechaRecibido) {
		this.total = total;
		this.numeroPedido = numeroPedido;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibido = fechaRecibido;
	}

	public Pedido(Integer id, Double total, String numeroPedido, LocalDate fechaCreacion, LocalDate fechaRecibido) {
		this.id = id;
		this.total = total;
		this.numeroPedido = numeroPedido;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibido = fechaRecibido;
	}

	public Pedido(Integer id, Double total, String numeroPedido, LocalDate fechaCreacion, LocalDate fechaRecibido,
			Cliente cliente) {
		this.id = id;
		this.total = total;
		this.numeroPedido = numeroPedido;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibido = fechaRecibido;
		this.cliente = cliente;
	}

	public Pedido(Integer id, Double total, String numeroPedido, LocalDate fechaCreacion, LocalDate fechaRecibido,
			Cliente cliente, DetallePedido detallePedido) {
		this.id = id;
		this.total = total;
		this.numeroPedido = numeroPedido;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibido = fechaRecibido;
		this.cliente = cliente;
		this.detallePedido = detallePedido;
	}

	public Integer getId() {
		return id;
	}

	public Double getTotal() {
		return total;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDate getFechaRecibido() {
		return fechaRecibido;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setFechaRecibido(LocalDate fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DetallePedido getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(DetallePedido detallePedido) {
		this.detallePedido = detallePedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", total=" + total + ", numeroPedido=" + numeroPedido + ", fechaCreacion="
				+ fechaCreacion + ", fechaRecibido=" + fechaRecibido + ", detallePedido="
				+ detallePedido + "]";
	}

}
