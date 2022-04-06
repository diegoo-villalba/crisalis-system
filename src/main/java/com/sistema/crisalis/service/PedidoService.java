package com.sistema.crisalis.service;

import java.util.List;
import java.util.Optional;

import com.sistema.crisalis.model.Cliente;
import com.sistema.crisalis.model.Pedido;

public interface PedidoService {
	
	// Defino todos los metodos para el CRUD de la clase Producto

		public Pedido insertar(Pedido Pedido);

		public Optional<Pedido> getUnPedido(Integer id);// Optional: nos permite validar si el objeto que llamamos de la
															// BBDD existe o no
		public void update(Pedido pedido);

		public void delete(Integer id);
		
		public List<Pedido> getPedidos();
		
		public String generarNumeroPedido();
		
		public List<Pedido> findByCliente(Cliente cliente);

}
