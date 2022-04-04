package com.sistema.crisalis.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto extends ItemVenta {

	public Producto() {
	}

}
