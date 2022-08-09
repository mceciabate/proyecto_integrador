package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.exceptions.ResourceCreateException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.Categoria;
import equipo10.integrador_v01.service.ICategoriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    ICategoriaService categoriasService;
    final static Logger log = Logger.getLogger(ICategoriaService.class);


    @GetMapping
    public ResponseEntity<?> listarTodasCategorias() throws ResourceNotFoundException {
        log.debug("Listado de categorías");
        return ResponseEntity.ok(categoriasService.listarTodasCategorias());
    }

    @PostMapping
    public ResponseEntity<?> guardarCategoria(@RequestBody Categoria categoria) throws ResourceCreateException {
        categoriasService.guardarCategoria(categoria);
        log.debug("Guardando nueva categoría " + categoria.toString());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarCategoria(@RequestParam Long id)throws ResourceNotFoundException{
        categoriasService.eliminarCategoria(id);
        log.debug("Se ha eliminado la categoría con id " + id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarCategoria(@RequestParam Long id, @RequestBody Categoria categoria) throws ResourceNotFoundException{
        categoriasService.actualizarCategoria(id, categoria);
        log.debug("Se ha acualizado la categoría " + categoria.toString());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
