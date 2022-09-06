package equipo10.integrador_v01.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ReservaDTO;
import equipo10.integrador_v01.model.entity.Reserva;
import equipo10.integrador_v01.repository.IReservaRepository;
import equipo10.integrador_v01.service.IReservaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService implements IReservaService {
    final static Logger log = Logger.getLogger(IReservaService.class);

    @Autowired
    IReservaRepository reservaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ReservaDTO guardarReserva(ReservaDTO reservaDTO) throws BadRequestException {
        Reserva nuevaReserva = mapper.convertValue(reservaDTO, Reserva.class);
        reservaRepository.save(nuevaReserva);
        log.info("Se ha creado la reserva " + nuevaReserva.toString());
        return mapper.convertValue(nuevaReserva, ReservaDTO.class);
    }

    @Override
    public List<ReservaDTO> filtrarReservasPorProducto(Long id) throws ResourceNotFoundException {
        List<Reserva> listaReservas = reservaRepository.findAll();
        List<ReservaDTO> listaDTO = new ArrayList<>();
        for (Reserva reserva : listaReservas) {
            if (reserva.getProducto().getId() == id) {
                listaDTO.add(mapper.convertValue(reserva, ReservaDTO.class));
            }
        }
        log.info("Rreservas que coinciden con el producto número " + id);
        return listaDTO;
    }
}
