package co.cafeteria.konecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import co.cafeteria.konecta.dto.ProductosDto;
import co.cafeteria.konecta.dto.VentaProductoDto;
import co.cafeteria.konecta.exception.RestException;
import co.cafeteria.konecta.model.Productos;
import co.cafeteria.konecta.service.iface.IProductoService;

/**
 * 
 * @author Faber
 *
 */


@Controller
public class ViewsController {
	
	@Autowired private ProductoController productoC;
	@Autowired private VentaProductoController ventaController;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("titulo", "Bienvenido a su cafeteria Konecta");
		return "home";
	}
	
	//vista para listar todos los productos
	@GetMapping(value = "listar")
	public String pruductos(Model modelo) {
		List<ProductosDto> listado = productoC.index();
		modelo.addAttribute("lista", listado);
		return "productos/listaProductos";
	}
	
	//vista para crear un producto	
	@GetMapping(value = "crear")
	public String crearProductos(Model modelo) {
		modelo.addAttribute("producto", new Productos());
		return "productos/crearProducto";
	}
	
	

	//vista que elimina un producto por id
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id")Long id, Model model) throws RestException {
		productoC.deleteProducto(id);
		return crearProductos(model);
		
	}
	//vista para crear una venta
	@GetMapping(value = "/venta")
	public String crearVenta(Model modelo) {
		modelo.addAttribute("venta", new VentaProductoController());
		return "ventaProducto/venta";
	}
	


}
