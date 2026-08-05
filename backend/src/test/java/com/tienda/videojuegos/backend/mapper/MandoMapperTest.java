package com.tienda.videojuegos.backend.mapper;

import com.tienda.videojuegos.backend.dto.mando.MandoCreateDTO;
import com.tienda.videojuegos.backend.dto.mando.MandoDTO;
import com.tienda.videojuegos.backend.model.Mando;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MandoMapperTest {

    @Test
    void constructorDebeLanzarExcepcion() throws Exception {
        Constructor<MandoMapper> constructor = MandoMapper.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        Exception exception = assertThrows(Exception.class, constructor::newInstance);
        assertThat(exception.getCause()).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toDTO_debeMapearCorrectamente() {
        // Arrange
        Mando mando = new Mando();
        mando.setId(1L);
        mando.setConsola("PlayStation");
        mando.setNombreMando("DualSense");
        mando.setPrecio(69.99);
        mando.setImagen("dualsense.jpg");

        // Act
        MandoDTO dto = MandoMapper.toDTO(mando);

        // Assert
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getConsola()).isEqualTo("PlayStation");
        assertThat(dto.getNombreMando()).isEqualTo("DualSense");
        assertThat(dto.getPrecio()).isEqualTo(69.99);
        assertThat(dto.getImagen()).isEqualTo("dualsense.jpg");
    }

    @Test
    void toEntity_debeMapearCorrectamente() {
        // Arrange
        MandoCreateDTO createDTO = new MandoCreateDTO();
        createDTO.setConsola("Xbox");
        createDTO.setNombreMando("Xbox Elite Controller");
        createDTO.setPrecio(149.99);
        createDTO.setImagen("elite.jpg");

        // Act
        Mando mando = MandoMapper.toEntity(createDTO);

        // Assert
        assertThat(mando.getId()).isNull(); // no se asigna en createDTO
        assertThat(mando.getConsola()).isEqualTo("Xbox");
        assertThat(mando.getNombreMando()).isEqualTo("Xbox Elite Controller");
        assertThat(mando.getPrecio()).isEqualTo(149.99);
        assertThat(mando.getImagen()).isEqualTo("elite.jpg");
    }

    @Test
    void updateEntity_debeActualizarCorrectamente() {
        // Arrange
        Mando mando = new Mando();
        mando.setId(10L);
        mando.setConsola("Nintendo");
        mando.setNombreMando("Joy-Con");
        mando.setPrecio(79.99);
        mando.setImagen("joycon.jpg");

        MandoCreateDTO updateDTO = new MandoCreateDTO();
        updateDTO.setConsola("Nintendo Switch");
        updateDTO.setNombreMando("Pro Controller");
        updateDTO.setPrecio(99.99);
        updateDTO.setImagen("procontroller.jpg");

        // Act
        MandoMapper.updateEntity(mando, updateDTO);

        // Assert
        assertThat(mando.getId()).isEqualTo(10L); // el id no cambia
        assertThat(mando.getConsola()).isEqualTo("Nintendo Switch");
        assertThat(mando.getNombreMando()).isEqualTo("Pro Controller");
        assertThat(mando.getPrecio()).isEqualTo(99.99);
        assertThat(mando.getImagen()).isEqualTo("procontroller.jpg");
    }
}