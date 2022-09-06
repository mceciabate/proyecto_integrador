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
import java.util.Optional;

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
        log.info("Rereservas que coinciden con el producto número " + id);
        return listaDTO;
    }

    @Override
    public void eliminarReserva(Long id) throws ResourceNotFoundException {
        Optional<Reserva> reservaAEliminar = reservaRepository.findById(id);
        if (reservaAEliminar.isPresent()) {
            log.info("Se ha eliminado la resrva " + id);
            reservaRepository.deleteById(id);
        } else throw new  ResourceNotFoundException("No se ha encontrado la reserva que se desea eliminar");

    }

    @Override
    public void actualizarReserva(ReservaDTO reservaDTO) throws ResourceNotFoundException {
        Optional<Reserva> reservaEncontrada = reservaRepository.findById(reservaDTO.getId());
        if (reservaEncontrada.isPresent()) {
            Reserva reservaActualizada = reservaEncontrada.get();
            reservaActualizada.setFechaInicio(reservaEncontrada.get().getFechaInicio());
            reservaActualizada.setFechaFin(reservaEncontrada.get().getFechaFin());
            reservaActualizada.setHoraInicio(reservaEncontrada.get().getHoraInicio());
            log.info("Se ha actualizado la reserva " + reservaEncontrada.toString());
            reservaRepository.saveAndFlush(reservaActualizada);
        } else throw new ResourceNotFoundException("No se puede modificar la reserva");

    }

    @Override
    public List<ReservaDTO> filtrarReservasPorUsuario(Long id) throws ResourceNotFoundException {
        List<Reserva> listaDeReservas = reservaRepository.findAll();
        List<ReservaDTO> listaDTO = new ArrayList<>();
        for (Reserva reserva : listaDeReservas) {
            if (reserva.getUsuario().getId() == id){
                listaDTO.add(mapper.convertValue(reserva, ReservaDTO.class));
            }
        } log.info("Reservas del usuario: " + id);
        return listaDTO;
    }
}
