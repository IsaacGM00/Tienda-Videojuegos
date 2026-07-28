package com.tienda.videojuegos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.videojuegos.backend.model.Juego;

public interface JuegoRepository extends JpaRepository<Juego, Long>{

}