package co.cafeteria.konecta.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.cafeteria.konecta.dto.VentaProductoDto;
import co.cafeteria.konecta.exception.BadRequestException;
import co.cafeteria.konecta.exception.ErrorDto;
import co.cafeteria.konecta.exception.NotFoundException;
import co.cafeteria.konecta.exception.RestException;
import co.cafeteria.konecta.mapper.VentaProductoMapper;
import co.cafeteria.konecta.model.Productos;
import co.cafeteria.konecta.model.VentaProducto;
import co.cafeteria.konecta.repository.IProductosRepository;
import co.cafeteria.konecta.repository.IVentaProductoRepository;
import co.cafeteria.konecta.service.iface.IVentaProductoService;
 @Service
public class VentaProductoServiceImpl implements IVentaProductoService {

	 @Autowired private IProductosRepository productoRepo;
	 @Autowired private IVentaProductoRepository ventaRepo;
	 
	@Override
	public VentaProducto crearVenta(VentaProducto ventaProducto) throws RestException {
		
		Optional<Productos> producto = productoRepo.findById(ventaProducto.getProducto().getId());
		Productos produc = null;
		if(producto.isPresent()) {
			produc = producto.get();
			produc.setStock(calcularStock(produc.getStock(),ventaProducto.getCantidad()));
			productoRepo.save(produc);
		}else {
			throw new NotFoundException(ErrorDto.getErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(),
					"El producto no existe", HttpStatus.NOT_FOUND.value()));
		}
		
		
		return ventaRepo.save(ventaProducto);
	}
	
	protected Long calcularStock(Long stockBd, Long stockVenta) throws RestException {
		
		Long resultado = null;
		if(stockBd >= stockVenta) {
			resultado = stockBd - stockVenta;
			
			if(resultado == 0) {
				System.out.println("No es posible realizar la venta");
				
			}
			
		}else {
			throw new BadRequestException(ErrorDto.getErrorDto(HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"El producto no existe", HttpStatus.BAD_REQUEST.value()));
		}
		
		return resultado;
	}
	
	@Override
	public List<VentaProductoDto> findAll(){
		List<VentaProducto> ventas = ventaRepo.findAll();
		List<VentaProductoDto> ventasMap = VentaProductoMapper.toVentaProductoDto(ventas);
		return ventasMap;
	}
	

	

}
