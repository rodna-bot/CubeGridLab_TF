package com.upc.cubegridlab.service;

import com.upc.cubegridlab.dtos.ComponenteDTO;
import com.upc.cubegridlab.dtos.CursoDTO;
import com.upc.cubegridlab.entidades.Componente;
import com.upc.cubegridlab.interfaces.IComponente;
import com.upc.cubegridlab.interfaces.IUsuarioCurso;
import com.upc.cubegridlab.repositorios.ComponenteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ComponenteServicio implements IComponente {
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private  ComponenteRepositorio componenteRepositorio;

    @Override
    public ComponenteDTO registrar(ComponenteDTO componenteDTO) {
        if (componenteDTO.getCodigo() == null) {
            if (componenteDTO.getNombre() != null) {
                if (componenteDTO.getTipo() != null) {
                    if (componenteDTO.getPrecio() != null) {
                        if (componenteDTO.getConsumo() != null) {
                            Componente componente = modelMapper.map(componenteDTO, Componente.class);
                            return  modelMapper.map(componenteRepositorio.save(componente), ComponenteDTO.class);
                        }
                    }
                }

            }

        }
        return null;
    }

    @Override
    public ComponenteDTO actualizar(ComponenteDTO componenteDTO) {
        if (componenteDTO.getCodigo() != null) {
            if (componenteDTO.getNombre() != null) {
                if (componenteDTO.getTipo() != null) {
                    if (componenteDTO.getPrecio() != null) {
                        if (componenteDTO.getConsumo() != null) {
                            if (componenteRepositorio.existsById(componenteDTO.getCodigo())) {
                                Componente componente = modelMapper.map(componenteDTO, Componente.class);
                                return modelMapper.map(componenteRepositorio.save(componente), ComponenteDTO.class);
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public void eliminar(Integer id) {
        if (id!=null && componenteRepositorio.existsById(id)) {
        componenteRepositorio.deleteById(id);
        }
    }

    @Override
    public List<ComponenteDTO> listar() {
        return componenteRepositorio.findAll().stream()
                .map(componente->modelMapper.map(componente, ComponenteDTO.class))
                .toList();
    }
}
