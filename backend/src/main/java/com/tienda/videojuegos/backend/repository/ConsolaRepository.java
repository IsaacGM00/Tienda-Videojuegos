package com.tienda.videojuegos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.videojuegos.backend.model.Consola;

public interface ConsolaRepository extends JpaRepository<Consola, Long>{
    
}