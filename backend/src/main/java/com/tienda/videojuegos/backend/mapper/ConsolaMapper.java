package com.tienda.videojuegos.backend.mapper;

import com.tienda.videojuegos.backend.dto.consola.ConsolaCreateDTO;
import com.tienda.videojuegos.backend.dto.consola.ConsolaDTO;
import com.tienda.videojuegos.backend.model.Consola;

public class ConsolaMapper {
    
    private ConsolaMapper(){
        throw new UnsupportedOperationException("Instaciación NO permitida");
    }

    public static ConsolaDTO toDTO(Consola consola){
        ConsolaDTO consolaDTO = new ConsolaDTO();
        consolaDTO.setId(consola.getId());
        consolaDTO.setSerieConsola(consola.getSerieConsola());
        consolaDTO.setNombreConsola(consola.getNombreConsola());
        consolaDTO.setPrecio(consola.getPrecio());
        consolaDTO.setImagen(consola.getImagen());
        return consolaDTO;
    }

    public static Consola toEntity(ConsolaCreateDTO consolaCreateDTO){
        Consola consola = new Consola();
        consola.setSerieConsola(consolaCreateDTO.getSerieConsola());
        consola.setNombreConsola(consolaCreateDTO.getNombreConsola());
        consola.setPrecio(consolaCreateDTO.getPrecio());
        consola.setImagen(consolaCreateDTO.getImagen());
        return consola;
    }

    public static void updateEntity(Consola consola, ConsolaCreateDTO consolaCreateDTO){
        consola.setSerieConsola(consolaCreateDTO.getSerieConsola());
        consola.setNombreConsola(consolaCreateDTO.getNombreConsola());
        consola.setPrecio(consolaCreateDTO.getPrecio());
        consola.setImagen(consolaCreateDTO.getImagen());
    }
    
}