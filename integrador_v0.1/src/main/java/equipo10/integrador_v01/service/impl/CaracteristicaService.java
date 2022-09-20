package equipo10.integrador_v01.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.model.dto.CaracteristicaDTO;
import equipo10.integrador_v01.model.dto.CategoriaDTO;
import equipo10.integrador_v01.model.entity.Caracteristica;
import equipo10.integrador_v01.model.entity.Categoria;
import equipo10.integrador_v01.repository.ICaracteristicaRepository;
import equipo10.integrador_v01.repository.ICategoriaRepository;
import equipo10.integrador_v01.service.ICaracteristicaService;
import equipo10.integrador_v01.service.ICategoriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CaracteristicaService implements ICaracteristicaService {

    final static Logger log = Logger.getLogger(ICategoriaService.class);
    @Autowired
    ICaracteristicaRepository caracteristicaRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public List<CaracteristicaDTO> listarCaracteristica() {
        List<CaracteristicaDTO> listaCaracteristicaDTO = new ArrayList<>();
        List<Caracteristica> listaCaracteristica = caracteristicaRepository.findAll();
        for (Caracteristica caracteristica : listaCaracteristica) {
            listaCaracteristicaDTO.add(mapper.convertValue(caracteristica, CaracteristicaDTO.class));
        }
        log.debug("Listado de categorías");
        return listaCaracteristicaDTO;
    }

    @Override
    public CaracteristicaDTO buscarCaracteristicaPorId(Long id) {
        CaracteristicaDTO caracteristicaEncontrada = mapper.convertValue(caracteristicaRepository.findById(id).orElse(null), CaracteristicaDTO.class);
        log.debug("Caracteristica " + id);
        return caracteristicaEncontrada;
    }
}
