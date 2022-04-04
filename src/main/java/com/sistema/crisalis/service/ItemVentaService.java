package com.sistema.crisalis.service;

import java.util.List;
import java.util.Optional;

import com.sistema.crisalis.model.ItemVenta;

public interface ItemVentaService {
	
	// Defino todos los metodos para el CRUD de la clase Producto

		public ItemVenta insertar(ItemVenta item);

		public Optional<ItemVenta> getItem(Integer id);// Optional: nos permite validar si el objeto que llamamos de la

		public void update(ItemVenta item);

		public void delete(Integer id);
		
		public List<ItemVenta> getItems();
	
	

}
