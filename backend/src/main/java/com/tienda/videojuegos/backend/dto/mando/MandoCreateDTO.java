package com.tienda.videojuegos.backend.dto.mando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MandoCreateDTO {
    private String consola;
    private String nombreMando;
    private Double precio;
}