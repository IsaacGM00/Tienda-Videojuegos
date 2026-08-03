package com.tienda.videojuegos.backend.dto.mando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MandoDTO {
    private Long id;
    private String consola;
    private String nombreMando;
    private Double precio;
    private String imagen;
}