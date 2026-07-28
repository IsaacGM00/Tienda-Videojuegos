package com.tienda.videojuegos.backend.dto.juego;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuegoCreateDTO {
    private String consola;
    private String nombreJuego;
    private Double precio;
}