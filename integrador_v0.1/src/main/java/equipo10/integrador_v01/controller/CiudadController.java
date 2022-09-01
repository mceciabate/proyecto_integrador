package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.model.dto.CiudadDTO;
import equipo10.integrador_v01.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    ICiudadService ciudadService;

    @GetMapping
    public ResponseEntity<List<CiudadDTO>> listarCiudades() {
        //ciudadService.listarCiudades();
        return ResponseEntity.ok(ciudadService.listarCiudades());
    }

    @PostMapping
    public ResponseEntity<CiudadDTO> guardarCiudad(@RequestBody CiudadDTO ciudadDTO) {
        //ciudadService.guardarCiudad(ciudadDTO);
        return ResponseEntity.ok(ciudadService.guardarCiudad(ciudadDTO));
    }
}
