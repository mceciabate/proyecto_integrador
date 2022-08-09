package equipo10.integrador_v01.controller;
import equipo10.integrador_v01.exceptions.ResourceCreateException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.CategoriaDTO;
import equipo10.integrador_v01.model.entity.Categoria;
import equipo10.integrador_v01.service.ICategoriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<CategoriaDTO>> listarTodasCategorias() throws ResourceNotFoundException {
        categoriasService.listarCategoria();
        log.debug("Listado de categorías");
        return ResponseEntity.ok(categoriasService.listarCategoria());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Long id) throws ResourceNotFoundException {
        categoriasService.listarCategoria();
        log.debug("Categoría " + id);
        return ResponseEntity.ok(categoriasService.buscarCategoriaPorId(id));
    }

    @PostMapping
    @RequestMapping("/guardar")
    public ResponseEntity<CategoriaDTO> guardarCategoria(@RequestBody CategoriaDTO categoriaDTO) throws ResourceCreateException {
        log.debug("Guardando nueva categoría " + categoriaDTO.toString());
        return ResponseEntity.ok(categoriasService.guardarCategoria(categoriaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        log.debug("Eliminando la categoria " + id);
       categoriasService.eliminarCategoria(id);
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) throws ResourceNotFoundException {
        categoriasService.actualizarCategoria(id, categoriaDTO);
        return null;
    }


}