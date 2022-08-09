package equipo10.integrador_v01.service.impl;

import equipo10.integrador_v01.model.Categoria;
import equipo10.integrador_v01.repository.ICategoriaRepository;
import equipo10.integrador_v01.service.ICategoriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    Logger LOG = Logger.getLogger(CategoriaService.class);

    //Inyección de dependencias
    //repository de hibernate (donde esta todos los metodos)
    @Autowired
    ICategoriaRepository categoriasRepository;

    //sobreescribo el CRUD

    @Override
    //implementar a futuro la excepcion de q no encuentre el id
    public List<Categoria> listarTodasCategorias() {
        return categoriasRepository.findAll();
    }

    @Override
    public Categoria buscarCategoriaXId(Long id) {
        Categoria categoriaEncontrada = categoriasRepository.findById(id).orElse(null);
        return categoriaEncontrada;
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriasRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriasRepository.deleteById(id);
    }

    @Override
    public void actualizarCategoria(Long id, Categoria categoria) {
        Optional<Categoria> categoriaOptional = categoriasRepository.findById(id);
        Categoria categoriaOp = categoriaOptional.get();
        if (categoriaOptional.isPresent()) {
            categoriaOp.setDescripcion(categoria.getDescripcion());
            categoriaOp.setTitulo(categoria.getTitulo());
            categoriaOp.setUrlImg(categoria.getTitulo());
            categoriasRepository.saveAndFlush(categoriaOp);
        }
    }
}
