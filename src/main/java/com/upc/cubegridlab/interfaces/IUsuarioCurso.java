package com.upc.cubegridlab.interfaces;

import com.upc.cubegridlab.dtos.CursoDTO;
import com.upc.cubegridlab.dtos.CursosPorUsuarioDTO;
import com.upc.cubegridlab.dtos.UsuarioCursoDTO;
import com.upc.cubegridlab.dtos.UsuarioDTO;

import java.util.List;

public interface IUsuarioCurso {
    public UsuarioCursoDTO registrar(UsuarioCursoDTO usuario);
    public UsuarioCursoDTO actualizar(Integer usuarioId, Integer cursoId, Integer nuevoUsuarioId, Integer nuevoCursoId);
    public void eliminar(Integer usuarioId, Integer cursoId);
    public List<UsuarioCursoDTO> listar();
    public List<CursosPorUsuarioDTO> listarCursosPorUsuario(Integer codigoUsuario);
}
