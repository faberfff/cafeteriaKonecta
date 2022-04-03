package co.cafeteria.konecta.dto;

import co.cafeteria.konecta.model.Productos;

public class VentaProductoDto {
	
	private Long id;
	private Productos producto;
	private Long cantidad;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the producto
	 */
	public Productos getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	/**
	 * @return the cantidad
	 */
	public Long getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	

}
