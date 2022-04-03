package com.sistema.crisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.crisalis.model.Producto;

@Repository //Para futuras inyecciones en los servicios
public interface ProductoDAO extends JpaRepository<Producto, Integer>{ //Con JpaRepositoryle indicamos la tabla en donde va a realizar el CRUD y el parámetro Integer id
	
	
	

}
