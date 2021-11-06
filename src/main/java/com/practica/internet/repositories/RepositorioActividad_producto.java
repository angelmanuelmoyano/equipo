package com.practica.internet.repositories;

import com.practica.internet.entities.Actividad_producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioActividad_producto extends JpaRepository<Actividad_producto, Long> {
}
