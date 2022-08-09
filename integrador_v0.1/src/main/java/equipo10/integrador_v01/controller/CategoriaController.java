package equipo10.integrador_v01.controller;
import java.util.*;
import equipo10.integrador_v01.exceptions.ResourceCreateException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.Categoria;
import equipo10.integrador_v01.service.ICategoriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    ICategoriaService categoriasService;
    final static Logger log = Logger.getLogger(ICategoriaService.class);


    @GetMapping
    @RequestMapping("/listar")
    public ResponseEntity<List<Categoria>> listarTodasCategorias() throws ResourceNotFoundException {
        categoriasService.listarCategoria();
        log.debug("Listado de categorías");
        return ResponseEntity.ok(categoriasService.listarCategoria());
    }

    @PostMapping
    @RequestMapping("/guardar")
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria) throws ResourceCreateException {
        log.debug("Guardando nueva categoría " + categoria.toString());
        return ResponseEntity.ok(categoriasService.guardarCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        log.debug("Eliminando la categoria " + id);
       categoriasService.eliminarCategoria(id);
        return null;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) throws ResourceNotFoundException {
        categoriasService.actualizarCategoria(id, categoria);


        return null;
    }


}