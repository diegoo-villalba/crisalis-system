package com.sistema.crisalis.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.crisalis.model.Cliente;
import com.sistema.crisalis.repository.ClienteDAO;
import com.sistema.crisalis.service.ClienteService;

@Service // Anotacion Service: nos permite inyectar en el controlador la clase y hacer el llamado a los metodos
public class ClienteServiceImpl implements ClienteService{

	/*
	 * Objeto Repository: La interfaz ProductoDAO del paquete repository obtiene
	 * todos los metodos CRUD (save, delete, find) que nos proprociona JpaRepository
	 */

	@Autowired // Inyectamos la dependencia
	private ClienteDAO clienteDAO;
	
	
	@Override
	public Cliente insertar(Cliente cliente) {
		return clienteDAO.save(cliente);
	}

	@Override
	public Optional<Cliente> getUnCliente(Integer id) {
		return clienteDAO.findById(id);
	}

	@Override
	public void update(Cliente cliente) {
		clienteDAO.save(cliente);
	}

	@Override
	public void delete(Integer id) {
		clienteDAO.deleteById(id);
	}

	@Override
	public List<Cliente> getClientes() {
		return clienteDAO.findAll();
	}

}
