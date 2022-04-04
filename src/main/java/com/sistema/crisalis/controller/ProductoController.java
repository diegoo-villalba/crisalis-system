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

import com.sistema.crisalis.model.Producto;
import com.sistema.crisalis.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	//Variable logger para testear por consola si realiza el crud y no insertar en la BBDD
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	//Inyectamos la interfaz ProductoService para poder implementar todos los metodos del CRUD
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String showProductos(Model model) { //El objeto model lleva la info desde el backend a la vista
		model.addAttribute("productos", productoService.getProductos()); //Enviamos a la variable "producto" la lista de producos obtenida de la BBDD
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
		productoService.insertar(producto);
		return "redirect:/productos"; //Una vez insertado el registro redireccionamos a la vista show
	}
	
	/*Metodo que recibe el ID de cada registro que lo obtenemos al apretar "Editar" y 
	 * con ese dato lo buscamos en la BBDD y lo traemos a la vista para luego poder editarlo*/
	
	@GetMapping("/edit/{id}") //Obtenemos el ID del registro que queremos editar, por eso colocamos el nombre de la variable
	public String edit(@PathVariable Integer id, Model model) {  //PathVariable: mapea el ID (variable) que viene en la URL y pasarla al argumento
		Producto producto = new Producto();
		
		Optional<Producto> optionalProducto = productoService.getUnProducto(id); //Definimos un objeto contenedor Optional para el Producto que traemos de la BBDD
		
		producto = optionalProducto.get();
		
		LOGGER.info("Producto buscado: {}", producto);
		
		model.addAttribute("producto", producto); //Nos envia todo el objeto buscado en la BBDD a la vista
		
		return "producto/edit";
	}
	
	@PostMapping("/update")
	public String update(Producto producto) {
		productoService.update(producto);
		return "redirect:/productos";
	}
	
	/*Metodo encargado de eliminar registro de la BBDD. Al igual que con update
	 * traemos el ID por URL al cual lo mapeamos para poder obtener en la BBDD
	 * el registro que queremos eliminar*/
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productoService.delete(id);
		return "redirect:/productos"; 
	}

}
