package com.sistema.crisalis.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.crisalis.model.ItemVenta;
import com.sistema.crisalis.service.ItemVentaService;

@Controller //Señalamos a Spring la clase como controlador
@RequestMapping("/home") 
public class HomeController {
	
	//Variable logger para testear por consola si realiza el crud y no insertar en la BBDD
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ItemVentaService itemVentaService;
	
	
	//Mapeamos la ruta a la pagina principal
	@GetMapping("")
	public String home() {
		
		return "home.html"; //Busca el archivo .html en Templates
	}
	
	@GetMapping("orden/{id}")
	public String agregarAlPedido(@PathVariable Integer id, Model model) {
		ItemVenta item = new ItemVenta();
		
		Optional<ItemVenta> itemOptional = itemVentaService.getItem(id);
		item = itemOptional.get();
		
		model.addAttribute("item", item);
		
		LOGGER.info("Id registro enviado como parámetro {}", id);
		
		return "cliente/orden";
	}
	
	
}
