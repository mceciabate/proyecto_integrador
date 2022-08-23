package equipo10.integrador_v01.controller;

import equipo10.integrador_v01.exceptions.BadRequestException;
import equipo10.integrador_v01.exceptions.ResourceNotFoundException;
import equipo10.integrador_v01.model.dto.ProductoDTO;
import equipo10.integrador_v01.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @GetMapping
    public ResponseEntity<Set<ProductoDTO>> traerTodosProductos(){
        productoService.listarProductos();
        return ResponseEntity.ok(productoService.listarProductos()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarProductoPorId(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<ProductoDTO> producto = Optional.ofNullable(productoService.buscarProductosPorId(id));
        if (producto.isPresent()){
            return ResponseEntity.ok(productoService.buscarProductosPorId(id));
        }else throw new ResourceNotFoundException("No se encontro el id solicitado");
    }
    @PostMapping
    public ResponseEntity<ProductoDTO> guardarProducto( @RequestBody ProductoDTO productoDTO) throws BadRequestException {
        productoService.guardarProductos(productoDTO);
        return ResponseEntity.ok(productoService.guardarProductos(productoDTO));
    }

    //ProductoDTO productoDTO = new ProductoDTO()
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) throws ResourceNotFoundException{
        productoService.eliminarProductos(id);
        return ResponseEntity.ok("Producto: "+ id +" fue eliminado con exito.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) throws ResourceNotFoundException{
        productoService.actualizarProductos(productoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/ciudad/{id}")
    public ResponseEntity<List<ProductoDTO>> buscarPorCiudad(@PathVariable Long id) throws ResourceNotFoundException{
        productoService.filtrarProductoPorCiudad(id);
        return ResponseEntity.ok(productoService.filtrarProductoPorCiudad(id));
    }

}
