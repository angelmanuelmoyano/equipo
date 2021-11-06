package com.practica.internet.repositories;

import com.practica.internet.entities.Contacto_sitio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioContacto_sitio extends JpaRepository<Contacto_sitio, Long> {
}
