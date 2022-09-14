package equipo10.integrador_v01.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import equipo10.integrador_v01.model.dto.ImagenDTO;
import equipo10.integrador_v01.model.entity.Imagen;
import equipo10.integrador_v01.repository.IImagenRepository;
import equipo10.integrador_v01.service.IImagenService;
import org.springframework.beans.factory.annotation.Autowired;

public class ImagenService implements IImagenService {

    @Autowired
    IImagenRepository imagenRepository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public ImagenDTO guardarImagen(ImagenDTO imagenDTO) {
        Imagen imagen = mapper.convertValue(imagenDTO, Imagen.class);
        imagenRepository.save(imagen);
        return mapper.convertValue(imagen, ImagenDTO.class);

    }
}
