package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.model.Categorias;
import equipo10.integrador_v01.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> guardarCategoria(@RequestBody Categorias categoria){
        categoriasService.guardarCategoria(categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarCategoria(@RequestParam Long id){
        categoriasService.eliminarCategoria(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarCategoria(@RequestParam Long id, @RequestBody Categorias categoria){
        categoriasService.actualizarCategoria(id, categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
