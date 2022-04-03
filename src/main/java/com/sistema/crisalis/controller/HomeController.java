package com.sistema.crisalis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Señalamos a Spring la clase como controlador
@RequestMapping("/home") 
public class HomeController {
	
	
	//Mapeamos la ruta a la pagina principal
	@GetMapping("")
	public String home() {
		
		return "home.html"; //Busca el archivo .html en Templates
	}
	
	
}
