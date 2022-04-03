package co.cafeteria.konecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.cafeteria.konecta.model.VentaProducto;

public interface IVentaProductoRepository extends JpaRepository<VentaProducto, Long> {

}
