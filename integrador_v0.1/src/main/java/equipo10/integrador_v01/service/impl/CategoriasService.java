package equipo10.integrador_v01.service.impl;

import equipo10.integrador_v01.model.Categorias;
import equipo10.integrador_v01.repository.ICategoriasRepository;
import equipo10.integrador_v01.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService implements ICategoriasService {

    //Inyección de dependencias
    //repository de hibernate (donde esta todos los metodos)
    @Autowired
    ICategoriasRepository categoriasRepository;

    //sobreescribo el CRUD

    @Override
    //implementar a futuro la excepcion de q no encuentre el id
    public List<Categorias> listarTodasCategorias() {
        return categoriasRepository.findAll();
    }

    @Override
    public Categorias buscarCategoriaXId(Long id) {
        Categorias categoriaEncontrada = categoriasRepository.findById(id).orElse(null);
        return categoriaEncontrada;
    }

    @Override
    public void guardarCategoria(Categorias categoria) {
        categoriasRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriasRepository.deleteById(id);
    }

    @Override
    public void actualizarCategoria(Categorias categoria) {
        categoriasRepository.saveAndFlush(categoria);
    }
}
