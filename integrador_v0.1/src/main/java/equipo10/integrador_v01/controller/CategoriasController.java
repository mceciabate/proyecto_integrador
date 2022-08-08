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
    @RequestMapping("/listar")
    public ResponseEntity<?> listarTodasCategorias(){
        categoriasService.listarTodasCategorias();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/guardar")
    public ResponseEntity<?> guardarCategoria(@RequestBody Categorias categoria){
        categoriasService.guardarCategoria(categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("/eliminar")
    public ResponseEntity<?> eliminarCategoria(@RequestParam Long id){
        categoriasService.eliminarCategoria(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    @RequestMapping("/editar")
    public ResponseEntity<?> actualizarCategoria(@RequestBody Categorias categoria){
        categoriasService.actualizarCategoria(categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
