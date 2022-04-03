package co.cafeteria.konecta.service.iface;

import java.util.List;

import co.cafeteria.konecta.dto.ProductosDto;
import co.cafeteria.konecta.exception.NotFoundException;
import co.cafeteria.konecta.exception.RestException;
import co.cafeteria.konecta.model.Productos;

public interface IProductoService {
	
	public Productos crearProducto(Productos producto);
	
	//public void editarProducto(Productos producto, Long productoId);
	
	public void eliminarProducto(Long id) throws NotFoundException;
	
	public List<ProductosDto> findAll();
	
	public Productos actualizar(Productos producto) throws RestException;

}
