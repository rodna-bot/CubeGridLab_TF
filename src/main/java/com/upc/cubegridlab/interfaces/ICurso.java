package com.upc.cubegridlab.interfaces;

import com.upc.cubegridlab.dtos.CursoDTO;
import com.upc.cubegridlab.dtos.UsuarioDTO;

import java.util.List;

public interface ICurso {
    public CursoDTO registrar(CursoDTO cursoDTO);
    public CursoDTO actualizar(CursoDTO cursoDTO);
    public void eliminar(Integer id);
    public List<CursoDTO> listar();
}
