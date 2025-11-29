package com.upc.cubegridlab.interfaces;

import com.upc.cubegridlab.dtos.ProyectoDTO;
import com.upc.cubegridlab.dtos.UsuarioDTO;

import java.util.List;

public interface IProyecto {
    public ProyectoDTO registrar(ProyectoDTO proyectoDTO);
    public ProyectoDTO actualizar(ProyectoDTO proyecto);
    public void eliminar(Integer id);
    public List<ProyectoDTO> listar();
    public ProyectoDTO buscarPorId(Integer id);
    public List<ProyectoDTO> listarPorUsuario(Integer id);
}
