package equipo10.integrador_v01.controller;


import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ReservaDTO;
import equipo10.integrador_v01.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    IReservaService reservaService;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<ReservaDTO> guardarReserva (@RequestBody  ReservaDTO reservaDTO) throws BadRequestException {
        return ResponseEntity.ok(reservaService.guardarReserva(reservaDTO));
    }

    @RequestMapping(value = "/producto/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ReservaDTO>> filtrarReservasPorProducto(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(reservaService.filtrarReservasPorProducto(id));
    }

}
