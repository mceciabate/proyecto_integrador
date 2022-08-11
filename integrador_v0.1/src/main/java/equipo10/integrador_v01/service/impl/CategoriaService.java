package equipo10.integrador_v01.service.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.model.entity.Categoria;
import equipo10.integrador_v01.model.dto.CategoriaDTO;
import equipo10.integrador_v01.repository.ICategoriaRepository;
import equipo10.integrador_v01.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    //Inyección de dependencias
    //repository de hibernate (donde esta todos los metodos)
    @Autowired
    ICategoriaRepository categoriasRepository;

    @Autowired
    ObjectMapper mapper;

    //sobreescribo el CRUD

    @Override
    //implementar a futuro la excepcion de q no encuentre el id
    public List<CategoriaDTO> listarCategoria() {
            List<CategoriaDTO> listaCategoriasDTO = new ArrayList<>();
            List<Categoria> listaCategorias = categoriasRepository.findAll();
            for (Categoria categoria : listaCategorias) {
                listaCategoriasDTO.add(mapper.convertValue(categoria, CategoriaDTO.class));
            }
            return listaCategoriasDTO;
    }

    @Override
    public CategoriaDTO buscarCategoriaPorId(Long id) {
        CategoriaDTO categoriaEncontrada = mapper.convertValue(categoriasRepository.findById(id).orElse(null), CategoriaDTO.class);
        return categoriaEncontrada;
    }

    @Override
    public CategoriaDTO guardarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoriaAGuardar = mapper.convertValue(categoriaDTO, Categoria.class);
        categoriasRepository.save(categoriaAGuardar);
        return mapper.convertValue(categoriaAGuardar, CategoriaDTO.class);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriasRepository.deleteById(id);
    }

    @Override
    public void actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaOptional = categoriasRepository.findById(id);
        Categoria categoriaOp = categoriaOptional.get();
        if (categoriaOptional.isPresent()) {
            categoriaOp.setDescripcion(categoriaDTO.getDescripcion());
            categoriaOp.setTitulo(categoriaDTO.getTitulo());
            categoriaOp.setUrlImg(categoriaDTO.getUrlImg());
            categoriasRepository.saveAndFlush(categoriaOp);
        }
    }

}
