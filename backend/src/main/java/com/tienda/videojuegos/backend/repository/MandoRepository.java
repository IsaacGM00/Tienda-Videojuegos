package com.tienda.videojuegos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.videojuegos.backend.model.Mando;

public interface MandoRepository extends JpaRepository<Mando, Long>{
    
}