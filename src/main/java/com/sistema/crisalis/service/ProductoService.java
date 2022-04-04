package com.sistema.crisalis.service;

import java.util.List;
import java.util.Optional;

import com.sistema.crisalis.model.Producto;

public interface ProductoService {
	// Defino todos los metodos para el CRUD de la clase Producto

	public Producto insertar(Producto producto);

	public Optional<Producto> getUnProducto(Integer id);// Optional: nos permite validar si el objeto que llamamos de la

	public void update(Producto producto);

	public void delete(Integer id);
	
	public List<Producto> getProductos();

}
