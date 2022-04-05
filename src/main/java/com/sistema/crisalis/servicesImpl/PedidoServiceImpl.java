package com.sistema.crisalis.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.crisalis.model.Pedido;
import com.sistema.crisalis.repository.PedidoDAO;
import com.sistema.crisalis.service.PedidoService;

@Service // Anotacion Service: nos permite inyectar en el controlador la clase y hacer el llamado a los metodos
public class PedidoServiceImpl implements PedidoService{
	
	/*
	 * Objeto Repository: La interfaz ProductoDAO del paquete repository obtiene
	 * todos los metodos CRUD (save, delete, find) que nos proprociona JpaRepository
	 */

	@Autowired // Inyectamos la dependencia
	private PedidoDAO pedidoDAO;

	@Override
	public Pedido insertar(Pedido pedido) {
		return pedidoDAO.save(pedido);
	}

	@Override
	public Optional<Pedido> getUnPedido(Integer id) {
		return pedidoDAO.findById(id);
	}

	@Override
	public void update(Pedido pedido) {
		pedidoDAO.save(pedido);
		
	}

	@Override
	public void delete(Integer id) {
		pedidoDAO.deleteById(id);
		
	}

	@Override
	public List<Pedido> getPedidos() {
		return pedidoDAO.findAll();
	}
	
	//Metodo para generar un numero de pedido (secuencial)
	public String generarNumeroPedido() {
		int numeroPedido = 0;
		String num = "";
		
		List<Pedido> pedidos = getPedidos();
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		return "";
	}

}
