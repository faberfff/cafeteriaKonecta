package co.cafeteria.konecta.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.cafeteria.konecta.dto.VentaProductoDto;
import co.cafeteria.konecta.exception.ErrorDto;
import co.cafeteria.konecta.exception.NotFoundException;
import co.cafeteria.konecta.exception.RestException;
import co.cafeteria.konecta.mapper.VentaProductoMapper;
import co.cafeteria.konecta.model.VentaProducto;
import co.cafeteria.konecta.service.iface.IVentaProductoService;

@RestController
@RequestMapping("/venta")
public class VentaProductoController {
	
	@Autowired
	private IVentaProductoService ventaService;
	
	@PostMapping("/crear")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<VentaProducto> crear(@RequestBody VentaProductoDto venta) throws RestException {
		if(Objects.isNull(venta)) {
			throw new NotFoundException(ErrorDto.getErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(),
					"El producto no existe", HttpStatus.NOT_FOUND.value()));
		
		}
		VentaProducto ventaProducto = VentaProductoMapper.toVentaProducto(venta);
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.crearVenta(ventaProducto));
		
 	}
	
	@GetMapping("listar")
	@ResponseStatus(HttpStatus.OK)
	public List<VentaProductoDto> index(){
		return ventaService.findAll();
	}

}
