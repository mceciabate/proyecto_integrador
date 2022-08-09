package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.model.Categoria;
import equipo10.integrador_v01.service.ICategoriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    ICategoriaService categoriasService;
    final static Logger log = Logger.getLogger(ICategoriaService.class);


    @GetMapping(path = "/all")
    public ResponseEntity<?> listarCategoria() {
        return ResponseEntity.ok(categoriasService.listarCategoria());
    }

    @GetMapping
    public ResponseEntity<?> buscarCategoriaPorId(@RequestParam Long id) {
        return ResponseEntity.ok(categoriasService.buscarCategoriaPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> guardarCategoria(@RequestBody Categoria categoria) {
        categoriasService.guardarCategoria(categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarCategoria(@RequestParam Long id) {
        categoriasService.eliminarCategoria(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarCategoria(@RequestParam Long id, @RequestBody Categoria categoria) {
        categoriasService.actualizarCategoria(id, categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
