package com.sistema.crisalis.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Servicio extends ItemVenta {

	private boolean esEspecial;

	public Servicio() {
	}

	public Servicio(boolean esEspecial) {
		this.esEspecial = esEspecial;
	}

	public boolean isEsEspecial() {
		return esEspecial;
	}

	public void setEsEspecial(boolean esEspecial) {
		this.esEspecial = esEspecial;
	}

}
