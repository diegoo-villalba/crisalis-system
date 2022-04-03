package com.sistema.crisalis.service;

import java.util.Optional;

import com.sistema.crisalis.model.Servicio;

public interface ServicioService {

	// Defino todos los metodos para el CRUD de la clase Producto

	public Servicio insertar(Servicio servicio);

	public Optional<Servicio> getUnServicio(Integer id);// Optional: nos permite validar si el objeto que llamamos de la
														// BBDD existe o no

	public void update(Servicio servicio);

	public void delete(Integer id);

}
