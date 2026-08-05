package com.tienda.videojuegos.backend.service;

import com.tienda.videojuegos.backend.dto.mando.MandoCreateDTO;
import com.tienda.videojuegos.backend.model.Mando;
import com.tienda.videojuegos.backend.repository.MandoRepository;
import com.tienda.videojuegos.backend.service.mando.MandoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MandoServiceImplTest {

    private MandoRepository mandoRepository;
    private MandoServiceImpl mandoService;

    @BeforeEach
    void setUp() {
        mandoRepository = mock(MandoRepository.class);
        mandoService = new MandoServiceImpl(mandoRepository);
    }

    @Test
    void createMando_debeGuardarYRetornarMando() {
        Mando mando = new Mando();
        mando.setId(1L);
        mando.setNombreMando("DualSense");

        when(mandoRepository.save(mando)).thenReturn(mando);

        Mando resultado = mandoService.createMando(mando);

        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getNombreMando()).isEqualTo("DualSense");
        verify(mandoRepository).save(mando);
    }

    @Test
    void createMandos_debeGuardarLista() {
        Mando m1 = new Mando(); m1.setId(1L);
        Mando m2 = new Mando(); m2.setId(2L);

        List<Mando> lista = Arrays.asList(m1, m2);

        when(mandoRepository.saveAll(lista)).thenReturn(lista);

        List<Mando> resultado = mandoService.createMandos(lista);

        assertThat(resultado).hasSize(2);
        verify(mandoRepository).saveAll(lista);
    }

    @Test
    void getMandoById_debeRetornarMandoSiExiste() {
        Mando mando = new Mando();
        mando.setId(1L);

        when(mandoRepository.findById(1L)).thenReturn(Optional.of(mando));

        Mando resultado = mandoService.getMandoById(1L);

        assertThat(resultado.getId()).isEqualTo(1L);
        verify(mandoRepository).findById(1L);
    }

    @Test
    void getMandoById_debeLanzarExcepcionSiNoExiste() {
        when(mandoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> mandoService.getMandoById(99L));
    }

    @Test
    void getAllMandos_debeRetornarLista() {
        Mando m1 = new Mando(); m1.setId(1L);
        Mando m2 = new Mando(); m2.setId(2L);

        when(mandoRepository.findAll()).thenReturn(Arrays.asList(m1, m2));

        List<Mando> resultado = mandoService.getAllMandos();

        assertThat(resultado).hasSize(2);
        verify(mandoRepository).findAll();
    }

    @Test
    void updateMando_debeActualizarYGuardar() {
        Mando mandoExistente = new Mando();
        mandoExistente.setId(1L);
        mandoExistente.setNombreMando("Antiguo");

        MandoCreateDTO dto = new MandoCreateDTO();
        dto.setNombreMando("Nuevo");
        dto.setConsola("PS5");
        dto.setPrecio(69.99);
        dto.setImagen("nuevo.jpg");

        when(mandoRepository.findById(1L)).thenReturn(Optional.of(mandoExistente));
        when(mandoRepository.save(mandoExistente)).thenReturn(mandoExistente);

        Mando resultado = mandoService.updateMando(1L, dto);

        assertThat(resultado.getNombreMando()).isEqualTo("Nuevo");
        assertThat(resultado.getConsola()).isEqualTo("PS5");
        assertThat(resultado.getPrecio()).isEqualTo(69.99);
        assertThat(resultado.getImagen()).isEqualTo("nuevo.jpg");
        verify(mandoRepository).save(mandoExistente);
    }

    @Test
    void updateMando_debeLanzarExcepcionSiNoExiste() {
        MandoCreateDTO dto = new MandoCreateDTO();
        dto.setNombreMando("Nuevo");

        when(mandoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> mandoService.updateMando(99L, dto));
    }

    @Test
    void deleteMando_debeEliminarPorId() {
        Long id = 1L;

        mandoService.deleteMando(id);

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(mandoRepository).deleteById(captor.capture());
        assertThat(captor.getValue()).isEqualTo(1L);
    }
}