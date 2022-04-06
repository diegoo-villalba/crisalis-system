package com.sistema.crisalis.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.crisalis.model.Cliente;
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
	@Override
	public String generarNumeroPedido() {
		//Inicializo una variable numero pedido, es la variable que se va a ir incrementando
		int numeroPedido = 0;
		
		//Nos devuelve el String con el secuencial del N° de orden
		String numeroConcatenado = "";
		
		//Lista que contiene los pedidos para obtener el numero del ultimo pedido ingresado
		List<Pedido> pedidos = getPedidos();
		
		//Lista de enteros donde vamos colocando el n° de pedido de c/orden (estan en String)
		List<Integer> numeros = new ArrayList<Integer>();
		
		//Parseamos de Integer(asi viene de la BBDD) a String: añado en mi lista "numeros" los n° ordenes "p" parseados
		pedidos.stream().forEach(p -> numeros.add(Integer.parseInt(p.getNumeroPedido())));
		
		if(pedidos.isEmpty()) { //Si no tenemos ningun pedido en la lista entonces es el primero
			numeroPedido = 1;
		} else { //Si la lista no viene vacia es porque ya tiene pedidos, entonces al mayor valor de la lista "numeros" le sumamos 1
			numeros.stream().max(Integer::compare).get(); //NOS DEVUELVE EL MAYOR NUMERO DE LA LISTA
			numeroPedido++;
		}
		
		//Debemos parsear de nuevo a String
		if (numeroPedido < 10) {
			numeroConcatenado = "0000"+String.valueOf(numeroPedido); //Concatenamos
		} else if (numeroPedido < 100) {
			numeroConcatenado = "000"+String.valueOf(numeroPedido); //Vamos quitando 0 (ceros) a medida que aumentan los digitos
		}
		
		return numeroConcatenado;
	}

	@Override
	public List<Pedido> findByCliente(Cliente cliente) {
		return pedidoDAO.findByCliente(cliente);
	}

}
