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

import com.tienda.videojuegos.backend.dto.mando.MandoCreateDTO;
import com.tienda.videojuegos.backend.dto.mando.MandoDTO;
import com.tienda.videojuegos.backend.mapper.MandoMapper;
import com.tienda.videojuegos.backend.model.Mando;
import com.tienda.videojuegos.backend.service.mando.MandoService;

@RestController
@RequestMapping("api/mandos")
public class MandoController {
    private final MandoService mandoService;

    MandoController(MandoService mandoService){
        this.mandoService = mandoService;
    }

    @PostMapping
    public MandoDTO createMando(@RequestBody MandoCreateDTO mandoCreateDTO) {
        Mando mando = MandoMapper.toEntity(mandoCreateDTO);
        Mando mandoGuardado = mandoService.createMando(mando);
        return MandoMapper.toDTO(mandoGuardado);
    }

    @PostMapping("/varios")
    public List<MandoDTO> createMandos(@RequestBody List<MandoCreateDTO> mandosCreateDTO) {
        List<Mando> mandos = mandosCreateDTO.stream()
                                  .map(MandoMapper::toEntity)
                                  .toList();
        List<Mando> mandosGuardados = mandoService.createMandos(mandos);
        return mandosGuardados.stream()
                          .map(MandoMapper::toDTO)
                          .toList();
    }

    @GetMapping
    public List<Mando> getAllMandos() {
        return mandoService.getAllMandos();
    }
    
    @GetMapping("{id}")
    public Mando searchMandoById(@PathVariable("id") Long id) {
        return mandoService.getMandoById(id);
    }

    @PutMapping("{id}")
    public MandoDTO updateMando(@PathVariable("id") Long id, @RequestBody MandoCreateDTO mandoCreateDTO) {
        Mando mandoActualizado = mandoService.updateMando(id, mandoCreateDTO);
        return MandoMapper.toDTO(mandoActualizado);
    }

    @DeleteMapping("{id}")
    public void deleteMandoById(@PathVariable("id") Long id){
        mandoService.deleteMando(id);
    }

}