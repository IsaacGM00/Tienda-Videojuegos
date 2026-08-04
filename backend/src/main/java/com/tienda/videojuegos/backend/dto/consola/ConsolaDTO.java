package com.tienda.videojuegos.backend.dto.consola;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsolaDTO {
    private Long id;
    private String serieConsola;
    private String nombreConsola;
    private Double precio;
    private String imagen;
}