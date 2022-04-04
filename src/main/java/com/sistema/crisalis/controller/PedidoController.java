package com.sistema.crisalis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.crisalis.model.Pedido;
import com.sistema.crisalis.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	// Variable logger para testear por consola si realiza el crud y no insertar en la BBDD
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	//Inyectamos la interfaz ProductoService para poder implementar todos los metodos del CRUD
	@Autowired
	private PedidoService pedidoService;

	@GetMapping("")
	public String showProductos(Model model) {
		model.addAttribute("pedidos", pedidoService.getPedidos());
		return "pedido/show";
	}

	@GetMapping("/create")
	public String create() {
		return "pedido/create";
	}
	
	//Metodo que mapea la información desde el metodo guardar en pagina "create"
	@PostMapping("/save")
	public String save(Pedido pedido) {
		LOGGER.info("Este es el objeto pedido {}",pedido); //Debemos tener el metodo toString() en la clase Pedido
		pedidoService.insertar(pedido);
		return "redirect:/pedidos"; //Una vez insertado el registro redireccionamos a la vista show
		}
	
	/*Metodo encargado de eliminar registro de la BBDD. Al igual que con update
	 * traemos el ID por URL al cual lo mapeamos para poder obtener en la BBDD
	 * el registro que queremos eliminar*/
		
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {  //PathVariable: mapea el ID (variable) que viene en la URL y pasarla al argumento
		pedidoService.delete(id);
		return "redirect:/pedidos"; 
	}
}
