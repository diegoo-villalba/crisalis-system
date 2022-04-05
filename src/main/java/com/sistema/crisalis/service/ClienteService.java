package com.sistema.crisalis.service;

import java.util.List;
import java.util.Optional;

import com.sistema.crisalis.model.Cliente;

public interface ClienteService {

	// Defino todos los metodos para el CRUD de la clase Producto

	public Cliente insertar(Cliente cliente);

	public Optional<Cliente> getUnCliente(Integer id);// Optional: contenedor que nos permite validar si el objeto que llamamos de la
														// BBDD existe o no
	public void update(Cliente cliente);

	public void delete(Integer id);
	
	public List<Cliente> getClientes();

}
