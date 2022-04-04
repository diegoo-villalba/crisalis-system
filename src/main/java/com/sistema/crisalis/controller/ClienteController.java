package com.sistema.crisalis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.crisalis.model.Cliente;
import com.sistema.crisalis.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	//Variable logger para testear por consola si realiza el crud y no insertar en la BBDD
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	//Inyectamos la interfaz ProductoService para poder implementar todos los metodos del CRUD
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("")
	public String showProductos(Model model) { //El objeto model lleva la info desde el backend a la vista
		model.addAttribute("clientes", clienteService.getClientes()); //Enviamos a la variable "clientes" la lista de clientes obtenida de la BBDD
		return "cliente/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "cliente/create";
	}
	
	//Metodo que mapea la información desde el metodo guardar en pagina "create"
	@PostMapping("/save")
	public String save(Cliente cliente) {
		LOGGER.info("Este es el objeto cliente {}",cliente); //Debemos tener el metodo toString() en la clase Cliente
		clienteService.insertar(cliente);
		return "redirect:/clientes"; //Una vez insertado el registro redireccionamos a la vista show
	}

}
