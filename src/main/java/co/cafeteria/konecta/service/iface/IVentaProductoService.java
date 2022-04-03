package co.cafeteria.konecta.service.iface;

import java.util.List;

import co.cafeteria.konecta.dto.VentaProductoDto;
import co.cafeteria.konecta.exception.RestException;
import co.cafeteria.konecta.model.VentaProducto;

public interface IVentaProductoService {
	
	public VentaProducto crearVenta(VentaProducto ventaProducto) throws RestException;
	
	public List<VentaProductoDto> findAll();
	
	

}
