package com.sistema.crisalis.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistema.crisalis.model.Cliente;
import com.sistema.crisalis.model.DetallePedido;
import com.sistema.crisalis.model.ItemVenta;
import com.sistema.crisalis.model.Pedido;
import com.sistema.crisalis.service.ClienteService;
import com.sistema.crisalis.service.DetallePedidoService;
import com.sistema.crisalis.service.ItemVentaService;
import com.sistema.crisalis.service.PedidoService;

@Controller //Señalamos a Spring la clase como controlador
@RequestMapping("/home") 
public class HomeController {
	
	@Autowired
	private ItemVentaService itemVentaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private DetallePedidoService detallePedidoService;
	
	//Variable logger para testear por consola si realiza el crud y no insertar en la BBDD
	private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	//Lista del Detalle del pedido donde almacenamos los items
	List<DetallePedido> detalles = new ArrayList<>();
	
	//Almacenamos el pedido y sus datos
	Pedido pedido = new Pedido();
	
	
	//Mapeamos la ruta a la pagina principal
	@GetMapping("")
	public String home(Model model, HttpSession session) {
		
		LOGGER.info("Sesion del usuario: {}", session.getAttribute("idCliente"));
		
		//session
		model.addAttribute("sesion", session.getAttribute("idCliente"));
		
		return "home.html"; //Busca el archivo .html en Templates
	}
	
	//Metodo que añade los items al pedido reicibendo por argumento el id
	
	@PostMapping("/orden")
	public String agregarAlPedido(@RequestParam Integer id, Model model) {
		
		//Declaramos las variables necesarias para generar el pedido
		DetallePedido detallePedido = new DetallePedido();
		ItemVenta item = new ItemVenta();
		Cliente cliente = new Cliente();
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
		
		/*
		//Comprobacion para verificar si tengo un servicio en la lista
		
		boolean ingresado = detalles.stream().anyMatch(i -> i.getItem().getClass().equals(servicio.getClass())); //boolean que nos verifica si un item en la lista
																												//"detalles" es de tipo "Servicio"
		
		if(ingresado) { Si es "true" (hay match) entonces
			//Agregamos el servicio a la lista PERO
			detalles.add(detallePedido);
			// cada producto que tengamos en nuestra lista detalle:
			for(DetallePedido detalleP : detalles) {
				if(detallePedido.getItem().getClass().equals(producto.getClass())) {
					double descuentoProducto = detalleP.getItem().getCosto() - (detalleP.getItem().getCosto()*DESCUENTO);
					
			}
			
		}
		}
		*/
		
		//Validamos que nuestra lista detalle del pedido no tenga ya el mismo item
		Integer idItem = item.getId();
		boolean ingresado = detalles.stream().anyMatch(i -> i.getItem().getId() == idItem);
		
		if(!ingresado) { //Si existe entonces anyMatch es true por eso !ingresado
			
			//Agregamos cada item y su detalle a la lista
			detalles.add(detallePedido);
			
		}
		
		
		//Funcion lambda: a todos los objetos de la lista detalles le obtenemos el total de c/item y lo sumamos
		sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		//Seteamos el total del pedido colocando el valor del total de la suma de la lista del pedido (funcion anterior)
		pedido.setTotal(sumaTotal);
		
		
		//Objeto model para llevar hacia la vista toda la informacion
		model.addAttribute("detallePedido", detalles); //Le pasamos a la orden el detalle de la lista de lo que añadio al pedido
		model.addAttribute("pedido", pedido); //Pasamos el pedido
		
		return "cliente/orden";
	}
	
	
	//Metodo que elimina un item del pedido
	
	@GetMapping("/delete/orden/{id}") //Obtenemos como atributo el Id del producto a borrar en la URL
	public String quitarDelPedido(@PathVariable Integer id, Model model) { //Buscamos el Item por ID y lo pasamos a la vista con Model
		
		//Lista nueva de productos: quitamos el producto de la lista, creamos una lista donde vamos poniendo los item que quedan
		List<DetallePedido> pedidoNuevo = new ArrayList<>();
		
		//Quitamos el producto de la variable global "detalles"
		for(DetallePedido detallePedido : detalles) {
			if(detallePedido.getItem().getId()!= id) { /*Si el id del producto de la lista que estamos 
														recorriendo es diferente al que viene por argumento 
														entonces lo agregamos a la lista nueva, porque si es igual
														entonces es el que estamos buscando eliminar*/
				pedidoNuevo.add(detallePedido); 
			}
		}
		
		/*Por ultimo colocamos en la lista global "detalles" el 
		 * contenido de la nueva lista (sin el item que queremos eliminar)*/
		detalles = pedidoNuevo;
		
		//Recalculamos de nuevo los precios y actualizamos la orden
		
		double sumaTotal = 0;
		
		//IDEM agregarAlPedido()
		sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		//Seteamos el total del pedido pero ahora ya con el producto que eliminamos (DEBERIA SER MENOR)
		pedido.setTotal(sumaTotal);
		
		//Objeto model para llevar hacia la vista toda la informacion
		model.addAttribute("detallePedido", detalles); //Le pasamos a la orden el detalle de la lista de lo que añadio al pedido
		model.addAttribute("pedido", pedido); //Pasamos el pedido
		
		
		return "cliente/orden";
	}
	
	@GetMapping("/nuevoPedido")
	public String nuevoPedido(Model model, HttpSession session) {
		
		model.addAttribute("detallePedido", detalles); //Le pasamos a la orden el detalle de la lista de lo que añadio al pedido
		model.addAttribute("pedido", pedido); //Pasamos el pedido
		
		//sesion
		model.addAttribute("sesion", session.getAttribute("idCliente"));
		
		return "cliente/orden";
	}
	
	@GetMapping("/resumenOrden")
	public String resumenOrden(Model model, HttpSession session) {
		
		Cliente cliente = clienteService.getUnCliente(Integer.parseInt(session.getAttribute("idCliente").toString())).get(); // .get() porque sino solo me retorna un Optional
		
		model.addAttribute("detallePedido", detalles); //Le pasamos a la orden el detalle de la lista de lo que añadio al pedido
		model.addAttribute("pedido", pedido); //Pasamos el pedido
		model.addAttribute("cliente", cliente);
		
		return "/cliente/resumenorden";
	}
	
	//Metodo para guardar el pedido cuando apretamos en "Generar" en la vista ResumenPedido
	@GetMapping("/guardarOrden")
	public String guardarOrden(HttpSession session) {
		
		//Variable fecha para guardar la fecha de creacion
		Date fechaCreacion = new Date();
		
		//Al pedido declarado previamente le seteamos la fecha
		pedido.setFechaCreacion(fechaCreacion);
		
		//Seteamos el numero de pedido
		pedido.setNumeroPedido(pedidoService.generarNumeroPedido());
		
		//Anadimos el cliente que realiza el pedido
		Cliente cliente = clienteService.getUnCliente(Integer.parseInt(session.getAttribute("idCliente").toString())).get();
		pedido.setCliente(cliente);
		
		//Guardamos el pedido
		pedidoService.insertar(pedido);
		
		//Guardamos los detalles del pedido
		for (DetallePedido dPedido : detalles) {
			dPedido.setPedido(pedido);
			detallePedidoService.insertar(dPedido); //Guardamos el detalle del pedido
		}
		
		//Limpiamos la lista si hay un nuevo pedido que agregar para el mismo cliente
		
		pedido = new Pedido(); //Generamos un nuevo pedido
		detalles.clear(); //LImpiamos el contenido de la lista
		
		
		return "redirect:/home/";
	}
	
	//Metodo que nos muestra los pedidos del cliente
	@GetMapping("/pedidosRealizados")
	public String obtenerPedidos(Model model, HttpSession session) {
		
		model.addAttribute("sesion", session.getAttribute("idCliente"));
		
		//Instanciamos un cliente y lo buscamos por Id
		Cliente cliente = clienteService.findById( Integer.parseInt(session.getAttribute("idCliente").toString())).get();
		
		//Definimos un Optional y le pasamos el cliente que lo obtenemos de la sesion para asi obtener su lista de pedidos
		List<Pedido> pedidoList =pedidoService.findByCliente(cliente);
		
		//Al modelo le pasamos la lista de ordenes del usuario
		model.addAttribute("pedidos", pedidoList);
		
		return "cliente/pedidos";
	}
	

}
