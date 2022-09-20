package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.CaracteristicaDTO;
import equipo10.integrador_v01.model.dto.ProductoDTO;
import equipo10.integrador_v01.service.ICaracteristicaService;
import equipo10.integrador_v01.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caracteristica")
public class CaracteristicaController {

    @Autowired
    ICaracteristicaService caracteritiscaService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<CaracteristicaDTO>> traerTodosCarcateristicas() {
        return ResponseEntity.ok(caracteritiscaService.listarCaracteristica());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CaracteristicaDTO> buscarCaracteristicasPorId(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<CaracteristicaDTO> caracteristica = Optional.ofNullable(caracteritiscaService.buscarCaracteristicaPorId(id));
        if (caracteristica.isPresent()) {
            return ResponseEntity.ok(caracteritiscaService.buscarCaracteristicaPorId(id));
        } else throw new ResourceNotFoundException("No se encontro el id solicitado");
    }

}
