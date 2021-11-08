package com.practica.internet.repositories;

import com.practica.internet.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDepartamento extends JpaRepository<Departamento, Long> {
}
