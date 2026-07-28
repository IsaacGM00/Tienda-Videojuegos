package com.tienda.videojuegos.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.videojuegos.backend.dto.consola.ConsolaCreateDTO;
import com.tienda.videojuegos.backend.dto.consola.ConsolaDTO;
import com.tienda.videojuegos.backend.mapper.ConsolaMapper;
import com.tienda.videojuegos.backend.model.Consola;
import com.tienda.videojuegos.backend.service.consola.ConsolaService;


@RestController
@RequestMapping("api/consolas")
public class ConsolaController {
    private final ConsolaService consolaService;

    ConsolaController(ConsolaService consolaService){
        this.consolaService = consolaService;
    }

    @PostMapping
    public ConsolaDTO createConsola(@RequestBody ConsolaCreateDTO consolaCreateDTO) {
        Consola consola = ConsolaMapper.toEntity(consolaCreateDTO);
        Consola consolaGuardada = consolaService.createConsola(consola);
        return ConsolaMapper.toDTO(consolaGuardada);
    }

    @GetMapping
    public List<Consola> getAllConsolas() {
        return consolaService.getAllConsolas();
    }
    
    @GetMapping("{id}")
    public Consola searchConsolaById(@PathVariable("id") Long id) {
        return consolaService.getConsolaById(id);
    }

    @PutMapping("{id}")
    public ConsolaDTO updateConsola(@PathVariable("id") Long id, @RequestBody ConsolaCreateDTO consolaCreateDTO) {
        Consola consolaActualizada = consolaService.updateConsola(id, consolaCreateDTO);
        return ConsolaMapper.toDTO(consolaActualizada);
    }

    @DeleteMapping("{id}")
    public void deleteConsolaById(@PathVariable("id") Long id){
        consolaService.deleteConsola(id);
    }

}