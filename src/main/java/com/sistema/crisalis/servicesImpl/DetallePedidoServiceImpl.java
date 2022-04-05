package com.sistema.crisalis.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.crisalis.model.DetallePedido;
import com.sistema.crisalis.repository.DetallePedidoDAO;
import com.sistema.crisalis.service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

	@Autowired
	private DetallePedidoDAO detallePedidoDAO;
	
	@Override
	public DetallePedido insertar(DetallePedido detallePedido) {
		return detallePedidoDAO.save(detallePedido);
	}

}
