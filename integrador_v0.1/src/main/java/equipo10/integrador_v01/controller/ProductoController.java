package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.exceptions.ValidationException;
import equipo10.integrador_v01.model.dto.CategoriaDTO;
import equipo10.integrador_v01.model.entity.Producto;
import equipo10.integrador_v01.service.ICategoriaService;
import equipo10.integrador_v01.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listarTodosProductos(){
        productoService.listarProductos();
        return ResponseEntity.ok(productoService.listarProductos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Producto> producto = Optional.ofNullable(productoService.buscarProductosPorId(id));
        if (producto.isPresent()) {
            return ResponseEntity.ok(productoService.buscarProductosPorId(id));
        } else throw new ResourceNotFoundException("No se encuentra el id");
    }
    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@Valid @RequestBody Producto producto){
        productoService.guardarProductos(producto);
        return ResponseEntity.ok(productoService.guardarProductos(producto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) throws ResourceNotFoundException {
        productoService.eliminarProductos(id);
        return ResponseEntity.ok("Producto: " + id + " eliminado con exito");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) throws ResourceNotFoundException {
        productoService.actualizarProductos(producto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
