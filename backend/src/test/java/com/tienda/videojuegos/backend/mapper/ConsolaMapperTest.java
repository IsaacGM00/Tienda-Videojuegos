package com.tienda.videojuegos.backend.mapper;

import com.tienda.videojuegos.backend.dto.consola.ConsolaCreateDTO;
import com.tienda.videojuegos.backend.dto.consola.ConsolaDTO;
import com.tienda.videojuegos.backend.model.Consola;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsolaMapperTest {

    @Test
    void constructorDebeLanzarExcepcion() throws Exception {
        Constructor<ConsolaMapper> constructor = ConsolaMapper.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        Exception exception = assertThrows(Exception.class, constructor::newInstance);
        assertThat(exception.getCause()).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toDTO_debeMapearCorrectamente() {
        // Arrange
        Consola consola = new Consola();
        consola.setId(1L);
        consola.setSerieConsola("PS5-001");
        consola.setNombreConsola("PlayStation 5");
        consola.setPrecio(499.99);
        consola.setImagen("ps5.jpg");

        // Act
        ConsolaDTO dto = ConsolaMapper.toDTO(consola);

        // Assert
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getSerieConsola()).isEqualTo("PS5-001");
        assertThat(dto.getNombreConsola()).isEqualTo("PlayStation 5");
        assertThat(dto.getPrecio()).isEqualTo(499.99);
        assertThat(dto.getImagen()).isEqualTo("ps5.jpg");
    }

    @Test
    void toEntity_debeMapearCorrectamente() {
        // Arrange
        ConsolaCreateDTO createDTO = new ConsolaCreateDTO();
        createDTO.setSerieConsola("XBX-2023");
        createDTO.setNombreConsola("Xbox Series X");
        createDTO.setPrecio(599.99);
        createDTO.setImagen("xbox.jpg");

        // Act
        Consola consola = ConsolaMapper.toEntity(createDTO);

        // Assert
        assertThat(consola.getId()).isNull(); // no se asigna en createDTO
        assertThat(consola.getSerieConsola()).isEqualTo("XBX-2023");
        assertThat(consola.getNombreConsola()).isEqualTo("Xbox Series X");
        assertThat(consola.getPrecio()).isEqualTo(599.99);
        assertThat(consola.getImagen()).isEqualTo("xbox.jpg");
    }

    @Test
    void updateEntity_debeActualizarCorrectamente() {
        // Arrange
        Consola consola = new Consola();
        consola.setId(10L);
        consola.setSerieConsola("NIN-001");
        consola.setNombreConsola("Nintendo Switch");
        consola.setPrecio(299.99);
        consola.setImagen("switch.jpg");

        ConsolaCreateDTO updateDTO = new ConsolaCreateDTO();
        updateDTO.setSerieConsola("NIN-002");
        updateDTO.setNombreConsola("Nintendo Switch OLED");
        updateDTO.setPrecio(349.99);
        updateDTO.setImagen("switch_oled.jpg");

        // Act
        ConsolaMapper.updateEntity(consola, updateDTO);

        // Assert
        assertThat(consola.getId()).isEqualTo(10L); // el id no cambia
        assertThat(consola.getSerieConsola()).isEqualTo("NIN-002");
        assertThat(consola.getNombreConsola()).isEqualTo("Nintendo Switch OLED");
        assertThat(consola.getPrecio()).isEqualTo(349.99);
        assertThat(consola.getImagen()).isEqualTo("switch_oled.jpg");
    }
}