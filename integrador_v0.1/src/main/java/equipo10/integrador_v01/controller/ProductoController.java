package equipo10.integrador_v01.controller;


import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ProductoDTO;
import equipo10.integrador_v01.model.entity.Producto;
import equipo10.integrador_v01.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @GetMapping
    public ResponseEntity<Set<ProductoDTO>> listarTodosProductos(){
        productoService.listarProductos();
        return ResponseEntity.ok(productoService.listarProductos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarProductoPorId(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<ProductoDTO> producto = Optional.ofNullable(productoService.buscarProductosPorId(id));
        if (producto.isPresent()) {
            return ResponseEntity.ok(productoService.buscarProductosPorId(id));
        } else throw new ResourceNotFoundException("No se encuentra el id");
    }
    @PostMapping
    public ResponseEntity<ProductoDTO> guardarProducto(@Valid @RequestBody ProductoDTO productoDTO) throws BadRequestException {
        productoService.guardarProductos(productoDTO);
        return ResponseEntity.ok(productoService.guardarProductos(productoDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) throws ResourceNotFoundException {
        productoService.eliminarProductos(id);
        return ResponseEntity.ok("Producto: " + id + " eliminado con exito");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) throws ResourceNotFoundException {
        productoService.actualizarProductos(productoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
