package com.tienda.videojuegos.backend.mapper;

import com.tienda.videojuegos.backend.dto.juego.JuegoCreateDTO;
import com.tienda.videojuegos.backend.dto.juego.JuegoDTO;
import com.tienda.videojuegos.backend.model.Juego;

public class JuegoMapper {
    
    // Constructor privado para evitar instanciación
    private JuegoMapper(){
        throw new UnsupportedOperationException("Instaciación NO permitida");
    }

    // Para salida de datos con id
    public static JuegoDTO toDTO(Juego juego){
        JuegoDTO juegoDTO = new JuegoDTO();
        juegoDTO.setId(juego.getId());
        juegoDTO.setConsola(juego.getConsola());
        juegoDTO.setNombreJuego(juego.getNombreJuego());
        juegoDTO.setPrecio(juego.getPrecio());
        juegoDTO.setImagen(juego.getImagen());
        return juegoDTO;
    }

    // Para entrada de datos sin id
    public static Juego toEntity(JuegoCreateDTO juegoCreateDTO){
        Juego juego = new Juego();
        juego.setConsola(juegoCreateDTO.getConsola());
        juego.setNombreJuego(juegoCreateDTO.getNombreJuego());
        juego.setPrecio(juegoCreateDTO.getPrecio());
        juego.setImagen(juegoCreateDTO.getImagen());
        return juego;
    }

    public static void updateEntity(Juego juego, JuegoCreateDTO juegoCreateDTO){
        juego.setConsola(juegoCreateDTO.getConsola());
        juego.setNombreJuego(juegoCreateDTO.getNombreJuego());
        juego.setPrecio(juegoCreateDTO.getPrecio());
        juego.setImagen(juegoCreateDTO.getImagen());
    }
}