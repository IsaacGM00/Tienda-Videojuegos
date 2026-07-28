package com.tienda.videojuegos.backend.dto.juego;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuegoDTO {
    private Long id;
    private String consola;
    private String nombreJuego;
    private Double precio;
    private String imagen;
}