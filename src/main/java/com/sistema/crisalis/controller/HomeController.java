package com.sistema.crisalis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistema.crisalis.model.DetallePedido;
import com.sistema.crisalis.model.ItemVenta;
import com.sistema.crisalis.model.Pedido;
import com.sistema.crisalis.service.ItemVentaService;

@Controller //Señalamos a Spring la clase como controlador
@RequestMapping("/home") 
public class HomeController {
	
	//Variable logger para testear por consola si realiza el crud y no insertar en la BBDD
	private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ItemVentaService itemVentaService;
	
	//Lista del Detalle del pedido donde almacenamos los items
	List<DetallePedido> detalles = new ArrayList<>();
	
	//Almacenamos el pedido y sus datos
	Pedido pedido = new Pedido();
	
	
	//Mapeamos la ruta a la pagina principal
	@GetMapping("")
	public String home() {
		
		return "home.html"; //Busca el archivo .html en Templates
	}
	
	/*@GetMapping("orden/{id}")
	public String agregarAlPedido(@PathVariable Integer id, Model model) { //Buscamos el Item por ID y lo pasamos a la vista con Model
		
		ItemVenta item = new ItemVenta();
		
		//Contenedor del item que buscamos en la BBDD por Id
		Optional<ItemVenta> itemOptional = itemVentaService.getItem(id);
		
		//Pasamos el item de Optional a la instancia Item
		item = itemOptional.get();
		
		//Enviamos el item a la vista a traves del modelo
		model.addAttribute("item", item);
		
		LOGGER.info("Id registro enviado como parámetro {}", id);
		
		return "cliente/orden";
	}
	*/
	
	//Metodo que añade los items al pedido reicibendo por argumento el id
	
	@PostMapping("/orden")
	public String agregarAlPedido(@RequestParam Integer id, Model model) {
		
		//Declaramos las variables necesarias para generar el pedido
		DetallePedido detallePedido = new DetallePedido();
		ItemVenta item = new ItemVenta();
		double sumaTotal = 0;
		
		Optional<ItemVenta> itemOptional = itemVentaService.getItem(id);
		
		LOGGER.info("Item añadido: {}", itemOptional.get());
		
		//Colocamos en la variable ITEM lo que tiene el contenedor Optional
		item = itemOptional.get();
		
		//Agregamos al detalle del pedido todo lo que la compone
		detallePedido.setPrecio(item.getCosto());
		detallePedido.setNombre(item.getNombre());
		detallePedido.setTotal(item.getCosto()*1);
		detallePedido.setItem(item);
		
		//Agregamos cada producto y su detalle a la lista
		detalles.add(detallePedido);
		
		//Funcion anonima: a todos los objetos de la lista detalles le obtenemos el total de c/item y lo sumamos
		sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		//Seteamos el total del pedido colocando el valor del total de la suma de la lista del pedido (funcion anterior)
		pedido.setTotal(sumaTotal);
		
		//Objeto model para llevar hacia la vista toda la informacion
		model.addAttribute("detallePedido", detalles); //Le pasamos a la orden el detalle de la lista de lo que añadio al pedido
		model.addAttribute("pedido", pedido); //Pasamos el pedido
		
		return "cliente/orden";
	}
	
}
