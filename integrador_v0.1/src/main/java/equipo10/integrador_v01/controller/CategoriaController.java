package equipo10.integrador_v01.controller;
import equipo10.integrador_v01.exceptions.BadRequestException;
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

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> listarTodasCategorias() throws ResourceNotFoundException, BadRequestException {
        categoriasService.listarCategoria();
        return ResponseEntity.ok(categoriasService.listarCategoria());
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Long id) throws ResourceNotFoundException, BadRequestException {
        categoriasService.listarCategoria();
        return ResponseEntity.ok(categoriasService.buscarCategoriaPorId(id));
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<CategoriaDTO> guardarCategoria(@RequestBody CategoriaDTO categoriaDTO) throws ResourceCreateException {
        return ResponseEntity.ok(categoriasService.guardarCategoria(categoriaDTO));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarCategoria(@PathVariable Long id) throws ResourceNotFoundException, BadRequestException {
       categoriasService.eliminarCategoria(id);
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) throws ResourceNotFoundException, BadRequestException {
        categoriasService.actualizarCategoria(id, categoriaDTO);
        return null;
    }


}