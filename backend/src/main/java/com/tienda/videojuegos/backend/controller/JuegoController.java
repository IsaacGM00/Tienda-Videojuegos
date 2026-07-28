package com.tienda.videojuegos.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.videojuegos.backend.dto.juego.JuegoCreateDTO;
import com.tienda.videojuegos.backend.dto.juego.JuegoDTO;
import com.tienda.videojuegos.backend.mapper.JuegoMapper;
import com.tienda.videojuegos.backend.model.Juego;
import com.tienda.videojuegos.backend.service.juego.JuegoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/juegos")

public class JuegoController {
    private final JuegoService juegoService;

    JuegoController(JuegoService juegoService){
        this.juegoService = juegoService;
    }

    @PostMapping
    public JuegoDTO createJuego(@RequestBody JuegoCreateDTO juegoCreateDTO) {
        Juego juego = JuegoMapper.toEntity(juegoCreateDTO);
        Juego juegoGuardado = juegoService.createJuego(juego);
        return JuegoMapper.toDTO(juegoGuardado);
    }

    @GetMapping
    public List<Juego> getAllJuegos() {
        return juegoService.getAllJuegos();
    }

    @GetMapping("{id}")
    public Juego searchJuegoById(@PathVariable("id") Long id) {
        return juegoService.getJuegoById(id);
    }

    @PutMapping("{id}")
    public JuegoDTO updateJuego(@PathVariable("id") Long id, @RequestBody JuegoCreateDTO juegoCreateDTO) {
        Juego juegoActualizado = juegoService.updateJuego(id, juegoCreateDTO);
        return JuegoMapper.toDTO(juegoActualizado);
    }

    @DeleteMapping("{id}")
    public void deleteJuegoById(@PathVariable("id") Long id) {
        juegoService.deleteJuego(id);
    }

}