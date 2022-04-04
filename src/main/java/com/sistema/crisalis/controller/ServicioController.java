package com.sistema.crisalis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.crisalis.model.Servicio;
import com.sistema.crisalis.service.ServicioService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	//Variable logger para testear por consola si realiza el crud y no insertar en la BBDD
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	//Inyectamos la interfaz ProductoService para poder implementar todos los metodos del CRUD
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping("")
	public String showProductos(Model model) {
		model.addAttribute("servicios", servicioService.getServicios());
		return "servicio/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "servicio/create";
	}
	
	//Metodo que mapea la información desde el metodo guardar en pagina "create"
	@PostMapping("/save")
	public String save(Servicio servicio) {
		LOGGER.info("Este es el objeto servicio {}",servicio); //Debemos tener el metodo toString() en la clase Servicio
		servicioService.insertar(servicio);
		return "redirect:/servicios"; //Una vez insertado el registro redireccionamos a la vista show
	}

}
