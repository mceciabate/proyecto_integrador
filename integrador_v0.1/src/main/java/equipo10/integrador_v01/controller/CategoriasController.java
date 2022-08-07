package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    ICategoriasService categoriasService;


    @GetMapping
    public ResponseEntity<?> listarTodasCategorias(){
        categoriasService.listarTodasCategorias();
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
