package com.profundizacion.profundizacion.repos;

import com.profundizacion.profundizacion.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    // @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %?1% "
    //       + "OR p.marca LIKE %?1% "
    //       + "OR p.hechoEn LIKE %?1%")

    @Query("SELECT p FROM Producto p WHERE "
            + " CONCAT(p.id, p.nombre, p.marca, p.hechoEn, p.precio) "
            + " LIKE %?1%")
    List<Producto> findAll(String palabraClave);
}
