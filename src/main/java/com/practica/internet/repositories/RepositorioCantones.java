package com.practica.internet.repositories;

import com.practica.internet.entities.Cantones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCantones extends JpaRepository<Cantones, Long> {
}
