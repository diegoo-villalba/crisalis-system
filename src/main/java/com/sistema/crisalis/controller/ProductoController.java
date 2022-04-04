package com.sistema.crisalis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.crisalis.model.Producto;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	//Variable logger para testear por consola si realiza el crud y no insertar en la BBDD
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	@GetMapping("")
	public String showProductos() {
		
		return "producto/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "producto/create";
	}
	
	//Metodo que mapea la información desde el metodo guardar en pagina "create"
	@PostMapping("/save")
	public String save(Producto producto) {
		LOGGER.info("Este es el objeto producto {}",producto); //Debemos tener el metodo toString() en la clase Producto
		return "redirect:/productos"; //Una vez insertado el registro redireccionamos a la vista show
	}
	

}
