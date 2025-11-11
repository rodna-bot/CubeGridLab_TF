package com.upc.cubegridlab.service;

import com.upc.cubegridlab.dtos.UsuarioDTO;
import com.upc.cubegridlab.entidades.Usuario;
import com.upc.cubegridlab.interfaces.IUsuarioServicio;
import com.upc.cubegridlab.repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio implements IUsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDTO registrar(UsuarioDTO usuarioDTO) {
        if(usuarioDTO.getUsername() != null && usuarioDTO.getPassword() != null){
            usuarioDTO.setCodigo(null);
            Usuario usuario = modelMapper.map(usuarioDTO,Usuario.class);
            return modelMapper.map(usuarioRepositorio.save(usuario), UsuarioDTO.class);
        }
        return null;
    }

    @Override
    public UsuarioDTO actualizar(UsuarioDTO usuarioDTO) {
        if(usuarioDTO.getCodigo() != null){
            if(usuarioDTO.getUsername() != null && usuarioDTO.getPassword() != null){
                if(usuarioRepositorio.existsById(usuarioDTO.getCodigo())){
                    Usuario usuario = modelMapper.map(usuarioDTO,Usuario.class);
                    return modelMapper.map(usuarioRepositorio.save(usuario), UsuarioDTO.class);
                }
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        if(id != null){
            if(usuarioRepositorio.existsById(id)){
                usuarioRepositorio.deleteById(id);
            }
        }
    }

    @Override
    public List<UsuarioDTO> listar() {
        return usuarioRepositorio.findAll().stream()
                .map(usuario->modelMapper.map(usuario, UsuarioDTO.class))
                .toList();
    }

    @Override
    public Integer buscarCodigodeUsuarioPorUsername(String username) {
        Usuario user = usuarioRepositorio.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.getCodigo();
    }
}
