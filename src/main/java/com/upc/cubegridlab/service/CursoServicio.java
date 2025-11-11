package com.upc.cubegridlab.service;

import com.upc.cubegridlab.dtos.CursoDTO;
import com.upc.cubegridlab.dtos.UsuarioDTO;
import com.upc.cubegridlab.entidades.Curso;
import com.upc.cubegridlab.interfaces.ICurso;
import com.upc.cubegridlab.repositorios.CursoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CursoServicio implements ICurso {
    @Autowired
    private CursoRepositorio cursoRepositorio ;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CursoDTO registrar(CursoDTO cursoDTO) {
        if(cursoDTO.getNombre() != null){
            cursoDTO.setCodigo(null);
            Curso curso = modelMapper.map(cursoDTO, Curso.class);
            return modelMapper.map(cursoRepositorio.save(curso), (Type) CursoDTO.class);

        }
        return null;
    }

    @Override
    public CursoDTO actualizar(CursoDTO cursoDTO) {
        if(cursoDTO.getCodigo() != null){
            if(cursoDTO.getNombre() != null ){

                    if(cursoRepositorio.existsById(cursoDTO.getCodigo())){
                            Curso curso = modelMapper.map(cursoDTO,Curso.class);
                        return modelMapper.map(cursoRepositorio.save(curso), (Type) CursoDTO.class);

                }
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        if(id != null){
            if(cursoRepositorio.existsById(id)){
                cursoRepositorio.deleteById(id);
            }
        }
    }

    @Override
    public List<CursoDTO> listar() {
        return cursoRepositorio.findAll().stream()
                .map(curso->modelMapper.map(curso, CursoDTO.class))
                .toList();
    }
}
