package com.sistema.crisalis.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.crisalis.model.Servicio;
import com.sistema.crisalis.repository.ServicioDAO;
import com.sistema.crisalis.service.ServicioService;

@Service // Anotacion Service: nos permite inyectar en el controlador la clase y hacer el llamado a los metodos
public class ServicioServiceImpl implements ServicioService{
	
	/*
	 * Objeto Repository: La interfaz ProductoDAO del paquete repository obtiene
	 * todos los metodos CRUD (save, delete, find) que nos proprociona JpaRepository
	 */

	@Autowired // Inyectamos la dependencia
	private ServicioDAO servicioDAO;

	@Override
	public Servicio insertar(Servicio servicio) {
		return servicioDAO.save(servicio);
	}

	@Override
	public Optional<Servicio> getUnServicio(Integer id) {
		return servicioDAO.findById(id);
	}

	@Override
	public void update(Servicio servicio) {
		servicioDAO.save(servicio);
		
	}

	@Override
	public void delete(Integer id) {
		servicioDAO.deleteById(id);
		
	}

}
