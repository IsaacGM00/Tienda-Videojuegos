package com.tienda.videojuegos.backend.service.consola;

import java.util.List;

import com.tienda.videojuegos.backend.dto.consola.ConsolaCreateDTO;
import com.tienda.videojuegos.backend.model.Consola;

public interface ConsolaService {
    Consola createConsola(Consola consola);
    List<Consola> createConsolas(List<Consola> consolas);
    Consola getConsolaById(Long id);
    List<Consola> getAllConsolas();
    Consola updateConsola(Long id, ConsolaCreateDTO consolaCreateDTO);
    void deleteConsola(Long id);
}