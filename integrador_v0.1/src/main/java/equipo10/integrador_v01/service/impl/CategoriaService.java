package equipo10.integrador_v01.service.impl;
import equipo10.integrador_v01.model.Categoria;
import equipo10.integrador_v01.repository.ICategoriaRepository;
import equipo10.integrador_v01.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    //Inyección de dependencias
    //repository de hibernate (donde esta todos los metodos)
    @Autowired
    ICategoriaRepository categoriasRepository;

    //sobreescribo el CRUD

    @Override
    //implementar a futuro la excepcion de q no encuentre el id
    public List<Categoria> listarCategoria() {
        return categoriasRepository.findAll();
    }

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
        Categoria categoriaEncontrada = categoriasRepository.findById(id).orElse(null);
        return categoriaEncontrada;
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        categoriasRepository.save(categoria);
        return categoria;
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriasRepository.deleteById(id);
    }

    @Override
    public Categoria actualizarCategoria(Long id, Categoria categoria) {
        Optional<Categoria> categoriaOptional = categoriasRepository.findById(id);
        Categoria categoriaOp = categoriaOptional.get();
        if (categoriaOptional.isPresent()) {
            categoriaOp.setDescripcion(categoria.getDescripcion());
            categoriaOp.setTitulo(categoria.getTitulo());
            categoriaOp.setUrlImg(categoria.getTitulo());
            categoriasRepository.saveAndFlush(categoriaOp);
        }
        return categoriaOp;
    }
}
