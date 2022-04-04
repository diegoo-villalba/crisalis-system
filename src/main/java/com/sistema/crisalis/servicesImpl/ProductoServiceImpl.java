package com.sistema.crisalis.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.crisalis.model.Producto;
import com.sistema.crisalis.repository.ProductoDAO;
import com.sistema.crisalis.service.ProductoService;

@Service // Anotacion Service: nos permite inyectar en el controlador la clase y hacer el
			// llamado a los metodos
public class ProductoServiceImpl implements ProductoService {

	/*
	 * Objeto Repository: La interfaz ProductoDAO del paquete repository obtiene
	 * todos los metodos CRUD (save, delete, find) que nos proprociona JpaRepository
	 */

	@Autowired // Inyectamos la dependencia
	private ProductoDAO productoDAO;

	@Override
	public Producto insertar(Producto producto) {
		return productoDAO.save(producto);
	}

	@Override
	public Optional<Producto> getUnProducto(Integer id) {
		return productoDAO.findById(id);
	}

	@Override
	public void update(Producto producto) {
		productoDAO.save(producto); // Si el objeto ya existe en la BBDD lo actualzia, por eso usamos "save" tambien

	}

	@Override
	public void delete(Integer id) {
		productoDAO.deleteById(id);
	}

	@Override
	public List<Producto> getProductos() {
		return productoDAO.findAll();
	}

}
