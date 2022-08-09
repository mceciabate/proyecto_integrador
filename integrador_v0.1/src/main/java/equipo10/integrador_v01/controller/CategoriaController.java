package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.model.Categoria;
import equipo10.integrador_v01.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    ICategoriaService categoriasService;

    @GetMapping
    public ResponseEntity<?> listarTodasCategorias(){
        return ResponseEntity.ok(categoriasService.listarTodasCategorias());
    }

    @PostMapping
    public ResponseEntity<?> guardarCategoria(@RequestBody Categoria categoria){
        categoriasService.guardarCategoria(categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarCategoria(@RequestParam Long id){
        categoriasService.eliminarCategoria(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarCategoria(@RequestParam Long id, @RequestBody Categoria categoria){
        categoriasService.actualizarCategoria(id, categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
