package com.practica.internet.repositories;

import com.practica.internet.entities.Locacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLocacion extends JpaRepository<Locacion,Long> {
}
