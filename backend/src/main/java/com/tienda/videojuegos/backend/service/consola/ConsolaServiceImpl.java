package com.tienda.videojuegos.backend.service.consola;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.videojuegos.backend.dto.consola.ConsolaCreateDTO;
import com.tienda.videojuegos.backend.mapper.ConsolaMapper;
import com.tienda.videojuegos.backend.model.Consola;
import com.tienda.videojuegos.backend.repository.ConsolaRepository;

@Service
public class ConsolaServiceImpl implements ConsolaService{
        private final ConsolaRepository consolaRepository;

    ConsolaServiceImpl(ConsolaRepository consolaRepository){
        this.consolaRepository = consolaRepository;
    }

    @Override
    public Consola createConsola(Consola consola) {
        return consolaRepository.save(consola);
    }

    @Override
    public List<Consola> createConsolas(List<Consola> consolas) {
        return consolaRepository.saveAll(consolas);
    }

    @Override
    public Consola getConsolaById(Long id) {
        return consolaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Consola> getAllConsolas() {
        return consolaRepository.findAll();
    }

    @Override
    public Consola updateConsola(Long id, ConsolaCreateDTO consolaCreateDTO) {
        Consola consolaExistente = consolaRepository.findById(id).
            orElseThrow(() -> new RuntimeException("Consola NO encontrada con el id " + id));
        
        ConsolaMapper.updateEntity(consolaExistente, consolaCreateDTO);

        return consolaRepository.save(consolaExistente);
    }

    @Override
    public void deleteConsola(Long id) {
        consolaRepository.deleteById(id);
    }

}