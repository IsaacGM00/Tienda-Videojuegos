package com.tienda.videojuegos.backend.controller;

import com.tienda.videojuegos.backend.dto.juego.JuegoCreateDTO;
import com.tienda.videojuegos.backend.dto.juego.JuegoDTO;
import com.tienda.videojuegos.backend.model.Juego;
import com.tienda.videojuegos.backend.service.juego.JuegoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JuegoControllerTest {

    @Mock
    private JuegoService juegoService;

    @InjectMocks
    private JuegoController juegoController;

    private Juego juego;
    private JuegoCreateDTO juegoCreateDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        juego = new Juego();
        juego.setId(1L);
        juego.setConsola("PlayStation");
        juego.setNombreJuego("God of War");
        juego.setPrecio(59.99);
        juego.setImagen("gow.jpg");

        juegoCreateDTO = new JuegoCreateDTO();
        juegoCreateDTO.setConsola("PlayStation");
        juegoCreateDTO.setNombreJuego("God of War");
        juegoCreateDTO.setPrecio(59.99);
        juegoCreateDTO.setImagen("gow.jpg");
    }

    @Test
    void testCreateJuego() {
        when(juegoService.createJuego(any(Juego.class))).thenReturn(juego);

        JuegoDTO result = juegoController.createJuego(juegoCreateDTO);

        assertNotNull(result);
        assertEquals("God of War", result.getNombreJuego());
        assertEquals("PlayStation", result.getConsola());
        verify(juegoService, times(1)).createJuego(any(Juego.class));
    }

    @Test
    void testCreateJuegos() {
        when(juegoService.createJuegos(anyList())).thenReturn(List.of(juego));

        List<JuegoDTO> result = juegoController.createJuegos(List.of(juegoCreateDTO));

        assertEquals(1, result.size());
        assertEquals("God of War", result.get(0).getNombreJuego());
        verify(juegoService, times(1)).createJuegos(anyList());
    }

    @Test
    void testGetAllJuegos() {
        when(juegoService.getAllJuegos()).thenReturn(List.of(juego));

        List<Juego> result = juegoController.getAllJuegos();

        assertEquals(1, result.size());
        assertEquals("God of War", result.get(0).getNombreJuego());
        verify(juegoService, times(1)).getAllJuegos();
    }

    @Test
    void testSearchJuegoById() {
        when(juegoService.getJuegoById(1L)).thenReturn(juego);

        Juego result = juegoController.searchJuegoById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(juegoService, times(1)).getJuegoById(1L);
    }

    @Test
    void testUpdateJuego() {
        when(juegoService.updateJuego(eq(1L), any(JuegoCreateDTO.class))).thenReturn(juego);

        JuegoDTO result = juegoController.updateJuego(1L, juegoCreateDTO);

        assertNotNull(result);
        assertEquals("God of War", result.getNombreJuego());
        verify(juegoService, times(1)).updateJuego(eq(1L), any(JuegoCreateDTO.class));
    }

    @Test
    void testDeleteJuegoById() {
        doNothing().when(juegoService).deleteJuego(1L);

        juegoController.deleteJuegoById(1L);

        verify(juegoService, times(1)).deleteJuego(1L);
    }
}