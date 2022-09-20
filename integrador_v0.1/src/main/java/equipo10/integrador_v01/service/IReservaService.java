package equipo10.integrador_v01.service;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ReservaDTO;

import java.util.List;

public interface IReservaService {

    ReservaDTO guardarReserva(ReservaDTO reservaDTO) throws BadRequestException;

    List<ReservaDTO> filtrarReservasPorProducto(Long id) throws ResourceNotFoundException;

    void eliminarReserva(Long id) throws ResourceNotFoundException;

    void actualizarReserva(ReservaDTO reservaDTO) throws ResourceNotFoundException;

    List<ReservaDTO> filtrarReservasPorUsuario(Long id) throws ResourceNotFoundException;
}
