package com.sistema.crisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.crisalis.model.Servicio;

@Repository // Para futuras inyecciones en los servicios
public interface ServicioDAO extends JpaRepository<Servicio, Integer> { /*
													 * Con JpaRepositoryle indicamos la tabla en donde va a realizar el
													 * CRUD y el parámetro Integer id
													 */

}
