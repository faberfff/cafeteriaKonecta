package co.cafeteria.konecta.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.cafeteria.konecta.dto.ProductosDto;
import co.cafeteria.konecta.dto.VentaProductoDto;
import co.cafeteria.konecta.service.iface.IProductoService;
import co.cafeteria.konecta.service.iface.IVentaProductoService;

@RestController
@RequestMapping("/consulta")
public class ConsultasController {
	
	@Autowired IProductoService productoS;
	@Autowired IVentaProductoService ventaProductoS;
	
    // consulta que permita conocer cuál es el producto que más stock tiene.
	
	@GetMapping("/mayorStock")
	public String masStock() {
		List<ProductosDto> listaProductos = productoS.findAll();
		Optional<Long> mayorStock;
		mayorStock = listaProductos.stream().map(p-> p.getStock()).max(Comparator.naturalOrder());
		return "Producto con mayor Stock" + mayorStock.get();
	}
	
	 //consulta que permite conocer cuál es el producto más vendido.

	@GetMapping("/mayorVenta")
	public String productoMasVendido() {
		List<VentaProductoDto> listaVentas = ventaProductoS.findAll();
		Optional<Long> productoMasVenta;
		productoMasVenta = listaVentas.stream().map(p-> p.getCantidad()).max(Comparator.naturalOrder());
		return "El producto mas vendido" + productoMasVenta;
	}
	

}
