package com.sistema.crisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.crisalis.model.Cliente;

@Repository // Para futuras inyecciones en los servicios
public interface ClienteDAO extends JpaRepository<Cliente, Integer> { 
	/*
	 * Con JpaRepositoryle indicamos la tabla en donde va a realizar el
	 * CRUD y el parámetro Integer id
	 */


}
