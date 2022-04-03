package com.sistema.crisalis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@GetMapping("")
	public String showProductos() {
		
		return "servicio/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "servicio/create";
	}

}
