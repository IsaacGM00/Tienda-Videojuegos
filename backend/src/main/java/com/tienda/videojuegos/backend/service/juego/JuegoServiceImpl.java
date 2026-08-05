package com.tienda.videojuegos.backend.service.juego;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.videojuegos.backend.dto.juego.JuegoCreateDTO;
import com.tienda.videojuegos.backend.mapper.JuegoMapper;
import com.tienda.videojuegos.backend.model.Juego;
import com.tienda.videojuegos.backend.repository.JuegoRepository;

@Service
public class JuegoServiceImpl implements JuegoService{
    private final JuegoRepository juegoRepository;

    public JuegoServiceImpl(JuegoRepository juegoRepository){
        this.juegoRepository = juegoRepository;
    }

    @Override
    public Juego createJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    @Override
    public List<Juego> createJuegos(List<Juego> juegos) {
        return juegoRepository.saveAll(juegos);
    }

    @Override
    public Juego getJuegoById(Long id) {
        return juegoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Juego> getAllJuegos() {
        return juegoRepository.findAll();
    }

    @Override
    public Juego updateJuego(Long id, JuegoCreateDTO juegoCreateDTO) {
        Juego juegoExistente = juegoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Juego NO encontrado con el id " + id));

        JuegoMapper.updateEntity(juegoExistente, juegoCreateDTO);

        return juegoRepository.save(juegoExistente);
    }

    @Override
    public void deleteJuego(Long id) {
        juegoRepository.deleteById(id);
    }

}