package com.tienda.videojuegos.backend.service;

import com.tienda.videojuegos.backend.dto.consola.ConsolaCreateDTO;
import com.tienda.videojuegos.backend.model.Consola;
import com.tienda.videojuegos.backend.repository.ConsolaRepository;
import com.tienda.videojuegos.backend.service.consola.ConsolaServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ConsolaServiceImplTest {

    private ConsolaRepository consolaRepository;
    private ConsolaServiceImpl consolaService;

    @BeforeEach
    void setUp() {
        consolaRepository = mock(ConsolaRepository.class);
        consolaService = new ConsolaServiceImpl(consolaRepository);
    }

    @Test
    void createConsola_debeGuardarYRetornarConsola() {
        Consola consola = new Consola();
        consola.setId(1L);
        consola.setNombreConsola("PlayStation 5");

        when(consolaRepository.save(consola)).thenReturn(consola);

        Consola resultado = consolaService.createConsola(consola);

        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getNombreConsola()).isEqualTo("PlayStation 5");
        verify(consolaRepository).save(consola);
    }

    @Test
    void createConsolas_debeGuardarLista() {
        Consola c1 = new Consola(); c1.setId(1L);
        Consola c2 = new Consola(); c2.setId(2L);

        List<Consola> lista = Arrays.asList(c1, c2);

        when(consolaRepository.saveAll(lista)).thenReturn(lista);

        List<Consola> resultado = consolaService.createConsolas(lista);

        assertThat(resultado).hasSize(2);
        verify(consolaRepository).saveAll(lista);
    }

    @Test
    void getConsolaById_debeRetornarConsolaSiExiste() {
        Consola consola = new Consola();
        consola.setId(1L);

        when(consolaRepository.findById(1L)).thenReturn(Optional.of(consola));

        Consola resultado = consolaService.getConsolaById(1L);

        assertThat(resultado.getId()).isEqualTo(1L);
        verify(consolaRepository).findById(1L);
    }

    @Test
    void getConsolaById_debeLanzarExcepcionSiNoExiste() {
        when(consolaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> consolaService.getConsolaById(99L));
    }

    @Test
    void getAllConsolas_debeRetornarLista() {
        Consola c1 = new Consola(); c1.setId(1L);
        Consola c2 = new Consola(); c2.setId(2L);

        when(consolaRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<Consola> resultado = consolaService.getAllConsolas();

        assertThat(resultado).hasSize(2);
        verify(consolaRepository).findAll();
    }

    @Test
    void updateConsola_debeActualizarYGuardar() {
        Consola consolaExistente = new Consola();
        consolaExistente.setId(1L);
        consolaExistente.setNombreConsola("Antigua");

        ConsolaCreateDTO dto = new ConsolaCreateDTO();
        dto.setNombreConsola("Nueva");
        dto.setSerieConsola("PS5-001");
        dto.setPrecio(499.99);
        dto.setImagen("nueva.jpg");

        when(consolaRepository.findById(1L)).thenReturn(Optional.of(consolaExistente));
        when(consolaRepository.save(consolaExistente)).thenReturn(consolaExistente);

        Consola resultado = consolaService.updateConsola(1L, dto);

        assertThat(resultado.getNombreConsola()).isEqualTo("Nueva");
        assertThat(resultado.getSerieConsola()).isEqualTo("PS5-001");
        assertThat(resultado.getPrecio()).isEqualTo(499.99);
        assertThat(resultado.getImagen()).isEqualTo("nueva.jpg");
        verify(consolaRepository).save(consolaExistente);
    }

    @Test
    void updateConsola_debeLanzarExcepcionSiNoExiste() {
        ConsolaCreateDTO dto = new ConsolaCreateDTO();
        dto.setNombreConsola("Nueva");

        when(consolaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> consolaService.updateConsola(99L, dto));
    }

    @Test
    void deleteConsola_debeEliminarPorId() {
        Long id = 1L;

        consolaService.deleteConsola(id);

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(consolaRepository).deleteById(captor.capture());
        assertThat(captor.getValue()).isEqualTo(1L);
    }
}
