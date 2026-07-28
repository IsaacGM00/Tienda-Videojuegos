package com.tienda.videojuegos.backend.service.mando;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.videojuegos.backend.dto.mando.MandoCreateDTO;
import com.tienda.videojuegos.backend.mapper.MandoMapper;
import com.tienda.videojuegos.backend.model.Mando;
import com.tienda.videojuegos.backend.repository.MandoRepository;

@Service
public class MandoServiceImpl implements MandoService{
    private final MandoRepository mandoRepository;

    MandoServiceImpl(MandoRepository mandoRepository){
        this.mandoRepository = mandoRepository;
    }

    @Override
    public Mando createMando(Mando mando) {
        return mandoRepository.save(mando);
    }

    @Override
    public Mando getMandoById(Long id) {
        return mandoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Mando> getAllMandos() {
        return mandoRepository.findAll();
    }

    @Override
    public Mando updateMando(Long id, MandoCreateDTO mandoCreateDTO) {
        Mando mandoExistente = mandoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Mando NO encontrado con el id " + id));
        
        MandoMapper.updateEntity(mandoExistente, mandoCreateDTO);

        return mandoRepository.save(mandoExistente);
    }

    @Override
    public void deleteMando(Long id) {
        mandoRepository.deleteById(id);
    }

}