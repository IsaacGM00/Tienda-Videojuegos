package com.tienda.videojuegos.backend.service.juego;

import java.util.List;

import com.tienda.videojuegos.backend.dto.juego.JuegoCreateDTO;
import com.tienda.videojuegos.backend.model.Juego;

public interface JuegoService {
    Juego createJuego(Juego juego);
    List<Juego> createJuegos(List<Juego> juegos);
    Juego getJuegoById(Long id);
    List<Juego> getAllJuegos();
    Juego updateJuego(Long id, JuegoCreateDTO juegoCreateDTO);
    void deleteJuego(Long id);
}