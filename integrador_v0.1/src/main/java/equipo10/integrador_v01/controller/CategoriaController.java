package equipo10.integrador_v01.controller;
import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceCreateException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.CategoriaDTO;
import equipo10.integrador_v01.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

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
        Optional<CategoriaDTO> categoria = Optional.ofNullable(categoriasService.buscarCategoriaPorId(id));
        if(categoria.isPresent()){
            return ResponseEntity.ok(categoriasService.buscarCategoriaPorId(id));
        }
        else throw new ResourceNotFoundException("No se encuentra el id");//Bien

    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<CategoriaDTO> guardarCategoria(@RequestBody CategoriaDTO categoriaDTO) throws BadRequestException {
        ResponseEntity<CategoriaDTO> CategoriaDTO = null;
        ResponseEntity<CategoriaDTO> categoria = CategoriaDTO;
        if (categoria.hasBody()){
            return ResponseEntity.ok(categoriasService.guardarCategoria(categoriaDTO));
        }
        else throw new BadRequestException("No se puede crear el recurso");//No muestra el mensaje
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CategoriaDTO> eliminarCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<CategoriaDTO> categoria = Optional.ofNullable(categoriasService.buscarCategoriaPorId(id));
        if(categoria.isPresent()) {
            categoriasService.eliminarCategoria(id);
        }
       else throw new ResourceNotFoundException("El id no existe");
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) throws ResourceNotFoundException, BadRequestException {
        Optional<CategoriaDTO> categoria = Optional.ofNullable(categoriasService.buscarCategoriaPorId(id));
       if(categoria.isPresent()){
           categoriasService.actualizarCategoria(id, categoriaDTO);
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       else throw new ResourceNotFoundException("El recurso que intenta actualizar no existe");
    }


}