package co.cafeteria.konecta.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.cafeteria.konecta.dto.ProductosDto;
import co.cafeteria.konecta.exception.ErrorDto;
import co.cafeteria.konecta.exception.NotFoundException;
import co.cafeteria.konecta.exception.RestException;
import co.cafeteria.konecta.mapper.ProductosMapper;
import co.cafeteria.konecta.model.Productos;
import co.cafeteria.konecta.repository.IProductosRepository;
import co.cafeteria.konecta.service.iface.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	
	@Autowired private IProductosRepository productoRepo; 
	
	@Override
	public Productos crearProducto(Productos producto) {
		
		return productoRepo.save(producto);
	}

//	@Override
//	public void editarProducto(Productos producto, Long productoId) {
//		Optional<Productos> existProducto = productoRepo.findById(productoId);
//		if(existProducto.isPresent()) {
//			existProducto.get().setNombre(producto.getNombre());
//			existProducto.get().setCategoria(producto.getCategoria());
//			existProducto.get().setFechaCreacion(producto.getFechaCreacion());
//			existProducto.get().setPeso(producto.getPeso());
//			existProducto.get().setPrecio(producto.getPrecio());
//			existProducto.get().setReferencia(producto.getReferencia());
//			existProducto.get().setStock(producto.getStock());
//			//existProducto.get().setEnabled(producto.getEnabled());
//			
//		}
//		productoRepo.save(existProducto.get());
//	}

	@Override
	public void eliminarProducto(Long id) throws NotFoundException{
		Productos productos = productoRepo.getById(id);
		if(Objects.nonNull(productos)) {
			productoRepo.delete(productos);
		}else {
			throw new NotFoundException(ErrorDto.getErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(),
					"Producto no existe", HttpStatus.NOT_FOUND.value()));
		}
			
		
		
	}

	@Override
	public List<ProductosDto> findAll() {
		List<Productos> productos = productoRepo.findAll();
		List<ProductosDto> productoMap = ProductosMapper.toProductosDto(productos);
		return productoMap;
	}
	
	@Override
	public Productos actualizar(Productos producto) throws RestException{
		Productos productoBd = productoRepo.getById(producto.getId());
		Productos productoTratado = null;
		if(Objects.nonNull(productoBd)) {
			productoTratado = ProductosMapper.producto(producto, productoBd);
			
			
			
		}else {
			throw new NotFoundException(ErrorDto.getErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(),
					"Producto no existe", HttpStatus.NOT_FOUND.value()));
		 	
		}
		return productoRepo.save(productoTratado);
		
	}

}
