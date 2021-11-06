package com.practica.internet.repositories;

import com.practica.internet.entities.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioOperador extends JpaRepository<Operador, Long> {
}
