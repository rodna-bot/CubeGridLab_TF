package com.upc.cubegridlab.interfaces;

import com.upc.cubegridlab.dtos.UsuarioDTO;
import com.upc.cubegridlab.entidades.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioServicio {
    public UsuarioDTO registrar(UsuarioDTO usuario);
    public UsuarioDTO actualizar(UsuarioDTO usuario);
    public void eliminar(Integer id);
    public List<UsuarioDTO> listar();
    public Integer buscarCodigodeUsuarioPorUsername(String username);
}
