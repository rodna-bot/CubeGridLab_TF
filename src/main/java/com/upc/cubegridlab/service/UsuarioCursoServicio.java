package com.upc.cubegridlab.service;

import com.upc.cubegridlab.dtos.*;
import com.upc.cubegridlab.entidades.*;
import com.upc.cubegridlab.interfaces.IUsuarioCurso;
import com.upc.cubegridlab.repositorios.CursoRepositorio;
import com.upc.cubegridlab.repositorios.UsuarioCursoRepositorio;
import com.upc.cubegridlab.repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioCursoServicio implements IUsuarioCurso {
    @Autowired UsuarioCursoRepositorio usuarioCursoRepositorio;
    @Autowired ModelMapper modelMapper;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private CursoRepositorio cursoRepositorio;


    @Override
    public UsuarioCursoDTO registrar(UsuarioCursoDTO usuarioCursoDTO) {
        System.out.println("INGRESO A LA FUNCION REGISTRAR");
        Usuario usuario = modelMapper.map(usuarioCursoDTO.getUsuarioId(), Usuario.class);
        Curso curso = modelMapper.map(usuarioCursoDTO.getCursoId(), Curso.class);
        UsuarioCursoId usuarioCursoId = new UsuarioCursoId(usuario.getCodigo(), curso.getCodigo());

        UsuarioCurso usuarioCurso = new UsuarioCurso(usuarioCursoId, usuario, curso);

        UsuarioCurso save = usuarioCursoRepositorio.save(usuarioCurso);

        return modelMapper.map(save, UsuarioCursoDTO.class);
    }

    @Override
    public UsuarioCursoDTO actualizar(Integer usuarioId, Integer cursoId, Integer nuevoUsuarioId, Integer nuevoCursoId) {
        if (usuarioId == null || cursoId == null || nuevoUsuarioId == null || nuevoCursoId == null) {
            return null;
        }

        UsuarioCursoId usuarioCursoId = new UsuarioCursoId(usuarioId, cursoId);

        if (usuarioCursoRepositorio.existsById(usuarioCursoId)) {
            usuarioCursoRepositorio.deleteById(usuarioCursoId);

            Usuario nuevoUsuario = usuarioRepositorio.findById(nuevoUsuarioId).orElse(null);
            Curso nuevoCurso = cursoRepositorio.findById(nuevoCursoId).orElse(null);

            if (nuevoUsuario != null && nuevoCurso != null) {
                UsuarioCursoId nuevoUsuarioCursoId = new UsuarioCursoId(nuevoUsuarioId, nuevoCursoId);

                UsuarioCurso nuevoUsuarioCurso = new UsuarioCurso();
                nuevoUsuarioCurso.setId(nuevoUsuarioCursoId);
                nuevoUsuarioCurso.setUsuario(nuevoUsuario);
                nuevoUsuarioCurso.setCurso(nuevoCurso);

                UsuarioCurso savedUsuarioCurso = usuarioCursoRepositorio.save(nuevoUsuarioCurso);

                return modelMapper.map(savedUsuarioCurso, UsuarioCursoDTO.class);
            }
        }

        return null;
    }

    @Override
    public void eliminar(Integer usuarioId, Integer cursoId) {
        if (usuarioId == null || cursoId == null) {
            return;
        }

        UsuarioCursoId usuarioCursoId = new UsuarioCursoId(usuarioId, cursoId);
        if (usuarioCursoRepositorio.existsById(usuarioCursoId)) {
            usuarioCursoRepositorio.deleteById(usuarioCursoId);
        }
    }

    @Override
    public List<UsuarioCursoDTO> listar() {
        return usuarioCursoRepositorio.findAll().stream()
                .map(usuarioCurso->modelMapper.map(usuarioCurso, UsuarioCursoDTO.class))
                .toList();
    }

    @Override
    public List<CursosPorUsuarioDTO> listarCursosPorUsuario(Integer codigoUsuario) {
        return usuarioCursoRepositorio.cursosPorUsuario(codigoUsuario);
    }
}
