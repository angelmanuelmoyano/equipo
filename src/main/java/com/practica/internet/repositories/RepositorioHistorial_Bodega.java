package com.practica.internet.repositories;

import com.practica.internet.entities.Historial_bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioHistorial_Bodega extends JpaRepository<Historial_bodega,Long> {
}
