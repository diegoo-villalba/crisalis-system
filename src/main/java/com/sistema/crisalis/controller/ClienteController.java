package com.sistema.crisalis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping("")
	public String showProductos() {
		
		return "cliente/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "cliente/create";
	}

}
