package com.practica.internet.repositories;

import com.practica.internet.entities.Provincias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProvincias extends JpaRepository<Provincias, Long> {
}
