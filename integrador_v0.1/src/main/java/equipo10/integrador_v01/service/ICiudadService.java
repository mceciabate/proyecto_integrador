package equipo10.integrador_v01.service;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.model.dto.CiudadDTO;
import equipo10.integrador_v01.model.dto.ProductoDTO;

import java.util.List;
import java.util.Set;


public interface ICiudadService {
    List<CiudadDTO> listarCiudades();

    CiudadDTO guardarCiudad(CiudadDTO ciudadDTO);

}
