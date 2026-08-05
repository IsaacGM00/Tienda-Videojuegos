package com.tienda.videojuegos.backend.service;

import com.tienda.videojuegos.backend.dto.juego.JuegoCreateDTO;
import com.tienda.videojuegos.backend.model.Juego;
import com.tienda.videojuegos.backend.repository.JuegoRepository;
import com.tienda.videojuegos.backend.service.juego.JuegoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class JuegoServiceImplTest {

    private JuegoRepository juegoRepository;
    private JuegoServiceImpl juegoService;

    @BeforeEach
    void setUp() {
        juegoRepository = mock(JuegoRepository.class);
        juegoService = new JuegoServiceImpl(juegoRepository);
    }

    @Test
    void createJuego_debeGuardarYRetornarJuego() {
        Juego juego = new Juego();
        juego.setId(1L);
        juego.setNombreJuego("God of War");

        when(juegoRepository.save(juego)).thenReturn(juego);

        Juego resultado = juegoService.createJuego(juego);

        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getNombreJuego()).isEqualTo("God of War");
        verify(juegoRepository).save(juego);
    }

    @Test
    void createJuegos_debeGuardarLista() {
        Juego j1 = new Juego(); j1.setId(1L);
        Juego j2 = new Juego(); j2.setId(2L);

        List<Juego> lista = Arrays.asList(j1, j2);

        when(juegoRepository.saveAll(lista)).thenReturn(lista);

        List<Juego> resultado = juegoService.createJuegos(lista);

        assertThat(resultado).hasSize(2);
        verify(juegoRepository).saveAll(lista);
    }

    @Test
    void getJuegoById_debeRetornarJuegoSiExiste() {
        Juego juego = new Juego();
        juego.setId(1L);

        when(juegoRepository.findById(1L)).thenReturn(Optional.of(juego));

        Juego resultado = juegoService.getJuegoById(1L);

        assertThat(resultado.getId()).isEqualTo(1L);
        verify(juegoRepository).findById(1L);
    }

    @Test
    void getJuegoById_debeLanzarExcepcionSiNoExiste() {
        when(juegoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> juegoService.getJuegoById(99L));
    }

    @Test
    void getAllJuegos_debeRetornarLista() {
        Juego j1 = new Juego(); j1.setId(1L);
        Juego j2 = new Juego(); j2.setId(2L);

        when(juegoRepository.findAll()).thenReturn(Arrays.asList(j1, j2));

        List<Juego> resultado = juegoService.getAllJuegos();

        assertThat(resultado).hasSize(2);
        verify(juegoRepository).findAll();
    }

    @Test
    void updateJuego_debeActualizarYGuardar() {
        Juego juegoExistente = new Juego();
        juegoExistente.setId(1L);
        juegoExistente.setNombreJuego("Antiguo");

        JuegoCreateDTO dto = new JuegoCreateDTO();
        dto.setNombreJuego("Nuevo");
        dto.setConsola("PS5");
        dto.setPrecio(59.99);
        dto.setImagen("nuevo.jpg");

        when(juegoRepository.findById(1L)).thenReturn(Optional.of(juegoExistente));
        when(juegoRepository.save(juegoExistente)).thenReturn(juegoExistente);

        Juego resultado = juegoService.updateJuego(1L, dto);

        assertThat(resultado.getNombreJuego()).isEqualTo("Nuevo");
        assertThat(resultado.getConsola()).isEqualTo("PS5");
        assertThat(resultado.getPrecio()).isEqualTo(59.99);
        assertThat(resultado.getImagen()).isEqualTo("nuevo.jpg");
        verify(juegoRepository).save(juegoExistente);
    }

    @Test
    void updateJuego_debeLanzarExcepcionSiNoExiste() {
        JuegoCreateDTO dto = new JuegoCreateDTO();
        dto.setNombreJuego("Nuevo");

        when(juegoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> juegoService.updateJuego(99L, dto));
    }

    @Test
    void deleteJuego_debeEliminarPorId() {
        Long id = 1L;

        juegoService.deleteJuego(id);

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(juegoRepository).deleteById(captor.capture());
        assertThat(captor.getValue()).isEqualTo(1L);
    }
}
