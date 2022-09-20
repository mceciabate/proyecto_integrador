package equipo10.integrador_v01.service;

import equipo10.integrador_v01.model.dto.CaracteristicaDTO;
import equipo10.integrador_v01.model.dto.CategoriaDTO;

import java.util.List;

public interface ICaracteristicaService {

    List<CaracteristicaDTO> listarCaracteristica();

    //read
    CaracteristicaDTO buscarCaracteristicaPorId(Long id);

}
