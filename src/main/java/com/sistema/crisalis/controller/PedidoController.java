package com.sistema.crisalis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@GetMapping("")
	public String showProductos() {
		
		return "pedido/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "pedido/create";
	}

}
