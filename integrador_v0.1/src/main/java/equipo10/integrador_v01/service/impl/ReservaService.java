package equipo10.integrador_v01.service.impl;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ReservaDTO;
import equipo10.integrador_v01.service.IReservaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService implements IReservaService {
    @Override
    public ReservaDTO guardarReserva(ReservaDTO reservaDTO) throws BadRequestException {
        return null;
    }

    @Override
    public List<ReservaDTO> filtrarReservasPorProducto(Long id) throws ResourceNotFoundException {
        return null;
    }
}
