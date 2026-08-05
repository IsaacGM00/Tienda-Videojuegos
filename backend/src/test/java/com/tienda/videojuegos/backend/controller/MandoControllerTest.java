package com.tienda.videojuegos.backend.controller;

import com.tienda.videojuegos.backend.dto.mando.MandoCreateDTO;
import com.tienda.videojuegos.backend.dto.mando.MandoDTO;
import com.tienda.videojuegos.backend.model.Mando;
import com.tienda.videojuegos.backend.service.mando.MandoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MandoControllerTest {

    @Mock
    private MandoService mandoService;

    @InjectMocks
    private MandoController mandoController;

    private Mando mando;
    private MandoCreateDTO mandoCreateDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mando = new Mando();
        mando.setId(1L);
        mando.setConsola("Xbox");
        mando.setNombreMando("Elite Controller");
        mando.setPrecio(149.99);
        mando.setImagen("elite.jpg");

        mandoCreateDTO = new MandoCreateDTO();
        mandoCreateDTO.setConsola("Xbox");
        mandoCreateDTO.setNombreMando("Elite Controller");
        mandoCreateDTO.setPrecio(149.99);
        mandoCreateDTO.setImagen("elite.jpg");
    }

    @Test
    void testCreateMando() {
        when(mandoService.createMando(any(Mando.class))).thenReturn(mando);

        MandoDTO result = mandoController.createMando(mandoCreateDTO);

        assertNotNull(result);
        assertEquals("Elite Controller", result.getNombreMando());
        assertEquals("Xbox", result.getConsola());
        verify(mandoService, times(1)).createMando(any(Mando.class));
    }

    @Test
    void testCreateMandos() {
        when(mandoService.createMandos(anyList())).thenReturn(List.of(mando));

        List<MandoDTO> result = mandoController.createMandos(List.of(mandoCreateDTO));

        assertEquals(1, result.size());
        assertEquals("Elite Controller", result.get(0).getNombreMando());
        verify(mandoService, times(1)).createMandos(anyList());
    }

    @Test
    void testGetAllMandos() {
        when(mandoService.getAllMandos()).thenReturn(List.of(mando));

        List<Mando> result = mandoController.getAllMandos();

        assertEquals(1, result.size());
        assertEquals("Elite Controller", result.get(0).getNombreMando());
        verify(mandoService, times(1)).getAllMandos();
    }

    @Test
    void testSearchMandoById() {
        when(mandoService.getMandoById(1L)).thenReturn(mando);

        Mando result = mandoController.searchMandoById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(mandoService, times(1)).getMandoById(1L);
    }

    @Test
    void testUpdateMando() {
        when(mandoService.updateMando(eq(1L), any(MandoCreateDTO.class))).thenReturn(mando);

        MandoDTO result = mandoController.updateMando(1L, mandoCreateDTO);

        assertNotNull(result);
        assertEquals("Elite Controller", result.getNombreMando());
        verify(mandoService, times(1)).updateMando(eq(1L), any(MandoCreateDTO.class));
    }

    @Test
    void testDeleteMandoById() {
        doNothing().when(mandoService).deleteMando(1L);

        mandoController.deleteMandoById(1L);

        verify(mandoService, times(1)).deleteMando(1L);
    }
}