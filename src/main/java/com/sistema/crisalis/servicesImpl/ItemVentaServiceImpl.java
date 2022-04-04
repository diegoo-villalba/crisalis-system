package com.sistema.crisalis.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.crisalis.model.ItemVenta;
import com.sistema.crisalis.repository.ItemVentaDAO;
import com.sistema.crisalis.service.ItemVentaService;

@Service // Anotacion Service: nos permite inyectar en el controlador la clase y hacer el
// llamado a los metodos
public class ItemVentaServiceImpl implements ItemVentaService {

	/*
	 * Objeto Repository: La interfaz ProductoDAO del paquete repository obtiene
	 * todos los metodos CRUD (save, delete, find) que nos proprociona JpaRepository
	 */

	@Autowired // Inyectamos la dependencia
	private ItemVentaDAO itemDAO;

	@Override
	public ItemVenta insertar(ItemVenta item) {
		return itemDAO.save(item);
	}

	@Override
	public Optional<ItemVenta> getItem(Integer id) {
		return itemDAO.findById(id);
	}

	@Override
	public void update(ItemVenta item) {
		itemDAO.save(item); // Si el objeto ya existe en la BBDD lo actualzia, por eso usamos "save" tambien

	}

	@Override
	public void delete(Integer id) {
		itemDAO.deleteById(id);

	}

	@Override
	public List<ItemVenta> getItems() {
		return itemDAO.findAll();
	}

}
