package com.upc.cubegridlab.controllers;

import com.upc.cubegridlab.dtos.UsuarioDTO;
import com.upc.cubegridlab.entidades.Usuario;
import com.upc.cubegridlab.interfaces.IUsuarioServicio;
import com.upc.cubegridlab.security.services.CustomUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioServicio usuarioServicio;
    @Autowired
    private PasswordEncoder bcrypt;

    @PostMapping("/registrar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public UsuarioDTO registrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        String bcryptPassword = bcrypt.encode(usuarioDTO.getPassword());
        usuarioDTO.setPassword(bcryptPassword);
        return usuarioServicio.registrar(usuarioDTO);
    }
    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public UsuarioDTO actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        String bcryptPassword = bcrypt.encode(usuarioDTO.getPassword());
        usuarioDTO.setPassword(bcryptPassword);
        return usuarioServicio.actualizar(usuarioDTO);
    }
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioServicio.eliminar(id);
    }
    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UsuarioDTO> listar(){
        return usuarioServicio.listar();
    }

    @GetMapping("/obtenerCodigo/{username}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Integer obtenerCodigoUsuario(@PathVariable String username){
        return usuarioServicio.buscarCodigodeUsuarioPorUsername(username);
    }
}
