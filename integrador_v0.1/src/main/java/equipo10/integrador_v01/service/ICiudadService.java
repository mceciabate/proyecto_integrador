package equipo10.integrador_v01.service;

import equipo10.integrador_v01.model.dto.CiudadDTO;

import java.util.List;


public interface ICiudadService {
    List<CiudadDTO> listarCiudades();

    CiudadDTO guardarCiudad(CiudadDTO ciudadDTO);

}
