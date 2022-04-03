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

//import com.konecta.cafeteria.entity.CafProductos;


@Controller
public class ViewsController {
	@Autowired private IProductoService productoS;
	@Autowired private ProductoController productoC;
	@Autowired private VentaProductoController ventaController;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("titulo", "Bienvenido a su cafeteria Konecta");
		return "home";
	}
	
	@GetMapping(value = "listar")
	public String pruductos(Model modelo) {
		List<ProductosDto> listado = productoS.findAll();
		modelo.addAttribute("lista", listado);
		return "productos/listaProductos";
	}
	
		
	@GetMapping(value = "crear")
	public String crearProductos(Model modelo) {
		modelo.addAttribute("producto", new Productos());
		return "productos/crearProducto";
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarProductos(@PathVariable("id")Long id, Model modelo) throws RestException {
		productoC.deleteProducto(id);
		return crearProductos(modelo) ;
		
		
	}
	
	@GetMapping(value = "/venta")
	public String crearVenta(Model modelo) {
		modelo.addAttribute("venta", new VentaProductoDto());
		return "ventaProducto/crearVenta";
	}
	


}
