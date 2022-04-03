package co.cafeteria.konecta.mapper;

import java.util.ArrayList;


import java.util.List;

import co.cafeteria.konecta.dto.ProductosDto;
import co.cafeteria.konecta.model.Productos;

/**
 * 
 * @author Faber
 *
 */

public class ProductosMapper {
	
	//ProcuctosDto toProductosDto(Producto producto)
	
	public static List<ProductosDto> toProductosDto (List<Productos> productos){
		List<ProductosDto> productosDto = new ArrayList<>();
		
		for(Productos produc : productos) {
			ProductosDto producto = new ProductosDto();
			producto.setId(produc.getId());
			producto.setNombre(produc.getNombre());
			producto.setCategoria(produc.getCategoria());
			producto.setPeso(produc.getPeso());
			producto.setPrecio(produc.getPrecio());
			producto.setReferencia(produc.getReferencia());
			producto.setFechaCreacion(produc.getFechaCreacion());
			producto.setStock(produc.getStock());
			productosDto.add(producto);
		}
		return productosDto;
	}
	
	public static Productos producto(Productos producto, Productos productoBd) {
		
		productoBd.setNombre(producto.getNombre());
		productoBd.setCategoria(producto.getCategoria());
		productoBd.setFechaCreacion(producto.getFechaCreacion());
		productoBd.setPeso(producto.getPeso());
		productoBd.setPrecio(producto.getPrecio());
		productoBd.setReferencia(producto.getReferencia());
		productoBd.setStock(producto.getStock());
		
		return productoBd;
	}

}
