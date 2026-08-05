package com.tienda.videojuegos.backend.controller;

import com.tienda.videojuegos.backend.dto.consola.ConsolaCreateDTO;
import com.tienda.videojuegos.backend.dto.consola.ConsolaDTO;
import com.tienda.videojuegos.backend.model.Consola;
import com.tienda.videojuegos.backend.service.consola.ConsolaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsolaControllerTest {

    @Mock
    private ConsolaService consolaService;

    @InjectMocks
    private ConsolaController consolaController;

    private Consola consola;
    private ConsolaCreateDTO consolaCreateDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        consola = new Consola();
        consola.setId(1L);
        consola.setNombreConsola("PlayStation 5");
        consola.setPrecio(499.99);
        consola.setImagen("ps5.jpg");

        consolaCreateDTO = new ConsolaCreateDTO();
        consolaCreateDTO.setNombreConsola("PlayStation 5");
        consolaCreateDTO.setPrecio(499.99);
        consolaCreateDTO.setImagen("ps5.jpg");
    }

    @Test
    void testCreateConsola() {
        when(consolaService.createConsola(any(Consola.class))).thenReturn(consola);

        ConsolaDTO result = consolaController.createConsola(consolaCreateDTO);

        assertNotNull(result);
        assertEquals("PlayStation 5", result.getNombreConsola());
        verify(consolaService, times(1)).createConsola(any(Consola.class));
    }

    @Test
    void testCreateConsolas() {
        when(consolaService.createConsolas(anyList())).thenReturn(List.of(consola));

        List<ConsolaDTO> result = consolaController.createConsolas(List.of(consolaCreateDTO));

        assertEquals(1, result.size());
        assertEquals("PlayStation 5", result.get(0).getNombreConsola());
        verify(consolaService, times(1)).createConsolas(anyList());
    }

    @Test
    void testGetAllConsolas() {
        when(consolaService.getAllConsolas()).thenReturn(List.of(consola));

        List<Consola> result = consolaController.getAllConsolas();

        assertEquals(1, result.size());
        assertEquals("PlayStation 5", result.get(0).getNombreConsola());
        verify(consolaService, times(1)).getAllConsolas();
    }

    @Test
    void testSearchConsolaById() {
        when(consolaService.getConsolaById(1L)).thenReturn(consola);

        Consola result = consolaController.searchConsolaById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(consolaService, times(1)).getConsolaById(1L);
    }

    @Test
    void testUpdateConsola() {
        when(consolaService.updateConsola(eq(1L), any(ConsolaCreateDTO.class))).thenReturn(consola);

        ConsolaDTO result = consolaController.updateConsola(1L, consolaCreateDTO);

        assertNotNull(result);
        assertEquals("PlayStation 5", result.getNombreConsola());
        verify(consolaService, times(1)).updateConsola(eq(1L), any(ConsolaCreateDTO.class));
    }

    @Test
    void testDeleteConsolaById() {
        doNothing().when(consolaService).deleteConsola(1L);

        consolaController.deleteConsolaById(1L);

        verify(consolaService, times(1)).deleteConsola(1L);
    }
}