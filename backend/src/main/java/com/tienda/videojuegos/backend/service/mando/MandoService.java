package com.tienda.videojuegos.backend.service.mando;

import java.util.List;

import com.tienda.videojuegos.backend.dto.mando.MandoCreateDTO;
import com.tienda.videojuegos.backend.model.Mando;

public interface MandoService {
    Mando createMando(Mando mando);
    Mando getMandoById(Long id);
    List<Mando> getAllMandos();
    Mando updateMando(Long id, MandoCreateDTO mandoCreateDTO);
    void deleteMando(Long id);
}