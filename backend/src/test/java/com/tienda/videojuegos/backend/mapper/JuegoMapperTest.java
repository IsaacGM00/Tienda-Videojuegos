package com.tienda.videojuegos.backend.mapper;

import com.tienda.videojuegos.backend.dto.juego.JuegoCreateDTO;
import com.tienda.videojuegos.backend.dto.juego.JuegoDTO;
import com.tienda.videojuegos.backend.model.Juego;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Constructor;

class JuegoMapperTest {

    @Test
    void constructorDebeLanzarExcepcion() throws Exception {
        Constructor<JuegoMapper> constructor = JuegoMapper.class.getDeclaredConstructor();
        constructor.setAccessible(true); // habilitamos acceso al constructor privado

        Exception exception = assertThrows(Exception.class, constructor::newInstance);

        // Verificamos que la causa sea UnsupportedOperationException
        assertThat(exception.getCause()).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toDTO_debeMapearCorrectamente() {
        // Arrange
        Juego juego = new Juego();
        juego.setId(1L);
        juego.setConsola("PlayStation");
        juego.setNombreJuego("God of War");
        juego.setPrecio(59.99);
        juego.setImagen("gow.jpg");

        // Act
        JuegoDTO dto = JuegoMapper.toDTO(juego);

        // Assert
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getConsola()).isEqualTo("PlayStation");
        assertThat(dto.getNombreJuego()).isEqualTo("God of War");
        assertThat(dto.getPrecio()).isEqualTo(59.99);
        assertThat(dto.getImagen()).isEqualTo("gow.jpg");
    }

    @Test
    void toEntity_debeMapearCorrectamente() {
        // Arrange
        JuegoCreateDTO createDTO = new JuegoCreateDTO();
        createDTO.setConsola("Xbox");
        createDTO.setNombreJuego("Halo Infinite");
        createDTO.setPrecio(69.99);
        createDTO.setImagen("halo.jpg");

        // Act
        Juego juego = JuegoMapper.toEntity(createDTO);

        // Assert
        assertThat(juego.getId()).isNull(); // porque no se asigna en createDTO
        assertThat(juego.getConsola()).isEqualTo("Xbox");
        assertThat(juego.getNombreJuego()).isEqualTo("Halo Infinite");
        assertThat(juego.getPrecio()).isEqualTo(69.99);
        assertThat(juego.getImagen()).isEqualTo("halo.jpg");
    }

    @Test
    void updateEntity_debeActualizarCorrectamente() {
        // Arrange
        Juego juego = new Juego();
        juego.setId(10L);
        juego.setConsola("Nintendo");
        juego.setNombreJuego("Zelda BOTW");
        juego.setPrecio(49.99);
        juego.setImagen("zelda.jpg");

        JuegoCreateDTO updateDTO = new JuegoCreateDTO();
        updateDTO.setConsola("Nintendo Switch");
        updateDTO.setNombreJuego("Zelda TOTK");
        updateDTO.setPrecio(69.99);
        updateDTO.setImagen("totk.jpg");

        // Act
        JuegoMapper.updateEntity(juego, updateDTO);

        // Assert
        assertThat(juego.getId()).isEqualTo(10L); // el id no cambia
        assertThat(juego.getConsola()).isEqualTo("Nintendo Switch");
        assertThat(juego.getNombreJuego()).isEqualTo("Zelda TOTK");
        assertThat(juego.getPrecio()).isEqualTo(69.99);
        assertThat(juego.getImagen()).isEqualTo("totk.jpg");
    }
}
