package com.sistema.crisalis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.crisalis.model.Cliente;
import com.sistema.crisalis.model.Pedido;

@Repository // Para futuras inyecciones en los servicios
public interface PedidoDAO extends JpaRepository<Pedido, Integer> { /*
	 * Con JpaRepositoryle indicamos la tabla en donde va a realizar el
	 * CRUD y el parámetro Integer id
	 */
	
	Optional<Pedido> findByCliente(Cliente cliente);
}
