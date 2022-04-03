package com.sistema.crisalis.service;

import java.util.Optional;

import com.sistema.crisalis.model.Producto;

public interface ProductoService {
	// Defino todos los metodos para el CRUD de la clase Producto

	public Producto insertar(Producto producto);

	public Optional<Producto> getUnProducto(Integer id);// Optional: nos permite validar si el objeto que llamamos de la
														// BBDD existe o no

	public void update(Producto producto);

	public void delete(Integer id);

}
