package com.tienda.videojuegos.backend.mapper;

import com.tienda.videojuegos.backend.dto.mando.MandoCreateDTO;
import com.tienda.videojuegos.backend.dto.mando.MandoDTO;
import com.tienda.videojuegos.backend.model.Mando;

public class MandoMapper {
    
    private MandoMapper(){
        throw new UnsupportedOperationException("Instaciación NO permitida");
    }

    public static MandoDTO toDTO(Mando mando){
        MandoDTO mandoDTO = new MandoDTO();
        mandoDTO.setId(mando.getId());
        mandoDTO.setConsola(mando.getConsola());
        mandoDTO.setNombreMando(mando.getNombreMando());
        mandoDTO.setPrecio(mando.getPrecio());
        mandoDTO.setImagen(mando.getImagen());
        return mandoDTO;
    }

    public static Mando toEntity(MandoCreateDTO mandoCreateDTO){
        Mando mando = new Mando();
        mando.setConsola(mandoCreateDTO.getConsola());
        mando.setNombreMando(mandoCreateDTO.getNombreMando());
        mando.setPrecio(mandoCreateDTO.getPrecio());
        mando.setImagen(mandoCreateDTO.getImagen());
        return mando;
    }

    public static void updateEntity(Mando mando, MandoCreateDTO mandoCreateDTO){
        mando.setConsola(mandoCreateDTO.getConsola());
        mando.setNombreMando(mandoCreateDTO.getNombreMando());
        mando.setPrecio(mandoCreateDTO.getPrecio());
        mando.setImagen(mandoCreateDTO.getImagen());
    }
    
}