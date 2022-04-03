package co.cafeteria.konecta.mapper;

import java.util.ArrayList;
import java.util.List;

import co.cafeteria.konecta.dto.VentaProductoDto;
import co.cafeteria.konecta.model.VentaProducto;

public class VentaProductoMapper {
	
	//VentaProductoDto toVentaProductoDto(VentaProducto ventaProducto)
	
	public static List<VentaProductoDto> toVentaProductoDto(List<VentaProducto> ventaProductos){
		List<VentaProductoDto> ventaProductoDto = new ArrayList<>();
		
		for(VentaProducto ventaP : ventaProductos) {
			VentaProductoDto ventaProducto = new VentaProductoDto(); 
			ventaProducto.setId(ventaP.getId());
			ventaProducto.setCantidad(ventaP.getCantidad());
			ventaProducto.setProducto(ventaP.getProducto());
			ventaProductoDto.add(ventaProducto);
			
		}
		return ventaProductoDto;
		
	}
	
	public static VentaProducto toVentaProducto(VentaProductoDto ventaProductoDto) {
		VentaProducto ventaProducto = new VentaProducto();
		ventaProducto.setCantidad(ventaProductoDto.getCantidad());
		ventaProducto.setProducto(ventaProductoDto.getProducto());
		
		return ventaProducto;
	}
	

}
