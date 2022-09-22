package equipo10.integrador_v01.controller;


import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ReservaDTO;
import equipo10.integrador_v01.service.IReservaService;
import equipo10.integrador_v01.service.jwt.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    IReservaService reservaService;
    @Autowired
    private EmailSenderService emailSenderService;

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<ReservaDTO> guardarReserva(@RequestBody ReservaDTO reservaDTO) throws BadRequestException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(reservaDTO.getUsuario().getEmail());
        mailMessage.setSubject("Sus reservas");
        mailMessage.setText("Su reserva ha sido creada exitosamente, para mas información visite: http://ubicar.ddns.net/");
        mailMessage.setFrom("${spring.mail.username}");
        emailSenderService.sendEmail(mailMessage);
        return ResponseEntity.ok(reservaService.guardarReserva(reservaDTO));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarReserva(@PathVariable Long id) throws ResourceNotFoundException {
        reservaService.eliminarReserva(id);
        return ResponseEntity.ok("Se ha eliminado la reserva " + id);
    }

    @RequestMapping(value = "/producto/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ReservaDTO>> filtrarReservasPorProducto(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(reservaService.filtrarReservasPorProducto(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> modificarReserva(@PathVariable Long id, @RequestBody ReservaDTO reservaDTO) throws ResourceNotFoundException {
        reservaService.actualizarReserva(reservaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ReservaDTO>> filtrarReservaPorUsuario(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(reservaService.filtrarReservasPorUsuario(id));
    }

}
