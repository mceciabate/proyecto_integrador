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
<<<<<<< HEAD
    public ResponseEntity<?> listarTodasCategorias() throws ResourceNotFoundException {
        log.debug("Listado de categorías");
        return ResponseEntity.ok(categoriasService.listarTodasCategorias());
    }

    @PostMapping
    public ResponseEntity<?> guardarCategoria(@RequestBody Categoria categoria) throws ResourceCreateException {
=======
    public ResponseEntity<?> buscarCategoriaPorId(@RequestParam Long id) {
        return ResponseEntity.ok(categoriasService.buscarCategoriaPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> guardarCategoria(@RequestBody Categoria categoria) {
>>>>>>> c474e48060ec4a4c91096b71e21f9a95ea406dd9
        categoriasService.guardarCategoria(categoria);
        log.debug("Guardando nueva categoría " + categoria.toString());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping
<<<<<<< HEAD
    public ResponseEntity<?> eliminarCategoria(@RequestParam Long id)throws ResourceNotFoundException{
=======
    public ResponseEntity<?> eliminarCategoria(@RequestParam Long id) {
>>>>>>> c474e48060ec4a4c91096b71e21f9a95ea406dd9
        categoriasService.eliminarCategoria(id);
        log.debug("Se ha eliminado la categoría con id " + id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
<<<<<<< HEAD
    public ResponseEntity<?> actualizarCategoria(@RequestParam Long id, @RequestBody Categoria categoria) throws ResourceNotFoundException{
=======
    public ResponseEntity<?> actualizarCategoria(@RequestParam Long id, @RequestBody Categoria categoria) {
>>>>>>> c474e48060ec4a4c91096b71e21f9a95ea406dd9
        categoriasService.actualizarCategoria(id, categoria);
        log.debug("Se ha acualizado la categoría " + categoria.toString());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
