package co.cafeteria.konecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.cafeteria.konecta.model.Productos;

@Repository
public interface IProductosRepository extends JpaRepository<Productos, Long>{

}
