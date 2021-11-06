package com.practica.internet.repositories;

import com.practica.internet.entities.Contacto_cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioContacto_cliente extends JpaRepository<Contacto_cliente, Long> {
}
