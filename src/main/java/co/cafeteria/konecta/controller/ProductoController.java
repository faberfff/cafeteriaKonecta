package co.cafeteria.konecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.cafeteria.konecta.dto.ProductosDto;
import co.cafeteria.konecta.exception.RestException;
import co.cafeteria.konecta.model.Productos;
import co.cafeteria.konecta.service.iface.IProductoService;

/**
 * 
 * @author Faber
 *
 */

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired IProductoService productoService;
	
	@PostMapping("/crear")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Productos create(@RequestBody Productos producto) {
		return productoService.crearProducto(producto);
	}
	
	@GetMapping("/listar")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductosDto> index(){
		return productoService.findAll();
	}
	
	@DeleteMapping("/borrar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteProducto(@PathVariable Long id) throws RestException{
		productoService.eliminarProducto(id);
	}
	
	@PutMapping("/actualizar")
	@ResponseStatus(code = HttpStatus.OK)
	 public void actualizar(@RequestBody Productos producto) throws RestException{
		 productoService.actualizar(producto);
		 
	 }
}
