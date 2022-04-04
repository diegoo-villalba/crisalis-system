package com.sistema.crisalis.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/*Metodo que recibe el ID de cada registro que lo obtenemos al apretar "Editar" y 
	 * con ese dato lo buscamos en la BBDD y lo traemos a la vista para luego poder editarlo*/
	
	@GetMapping("/edit/{id}") //Obtenemos el ID del registro que queremos editar, por eso colocamos el nombre de la variable
	public String edit(@PathVariable Integer id, Model model) {  //PathVariable: mapea el ID (variable) que viene en la URL y pasarla al argumento
		Cliente cliente = new Cliente();
		
		Optional<Cliente> optionalCliente = clienteService.getUnCliente(id); /*Definimos un objeto contenedor Optional 
																				para el Cliente que traemos de la BBDD*/
		
		cliente = optionalCliente.get();
		
		LOGGER.info("Cliente buscado: {}", cliente);
		
		model.addAttribute("cliente", cliente); //Nos envia todo el objeto buscado en la BBDD a la vista
		
		return "cliente/edit";
	}
	
	@PostMapping("/update")
	public String update(Cliente cliente) {
		clienteService.update(cliente);
		return "redirect:/clientes";
	}
	
	/*Metodo encargado de eliminar registro de la BBDD. Al igual que con update
	 * traemos el ID por URL al cual lo mapeamos para poder obtener en la BBDD
	 * el registro que queremos eliminar*/
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		clienteService.delete(id);
		return "redirect:/clientes"; 
	}

}
