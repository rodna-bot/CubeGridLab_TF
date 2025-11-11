package com.upc.cubegridlab.controllers;

import com.upc.cubegridlab.dtos.CursosPorUsuarioDTO;
import com.upc.cubegridlab.dtos.UsuarioCursoDTO;
import com.upc.cubegridlab.dtos.UsuarioDTO;
import com.upc.cubegridlab.entidades.UsuarioCurso;
import com.upc.cubegridlab.interfaces.ICurso;
import com.upc.cubegridlab.interfaces.IUsuarioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api/UsuarioCurso")
public class UsuarioCursoController {

    @Autowired
    IUsuarioCurso usuarioCursointerface;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<UsuarioCursoDTO> listar(){
        return usuarioCursointerface.listar();
    }
    @PostMapping("/registrar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public UsuarioCursoDTO registrarUsuarioCurso(@RequestBody UsuarioCursoDTO usuarioCursoDTO){
        return usuarioCursointerface.registrar(usuarioCursoDTO);
    }
    @PutMapping("/actualizar/{usuarioId}/{cursoId}/{nuevoUsuarioId}/{nuevoCursoId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public UsuarioCursoDTO actualizarUsuarioCurso(@PathVariable Integer usuarioId, @PathVariable Integer cursoId, @PathVariable Integer nuevoUsuarioId, @PathVariable Integer nuevoCursoId){
        return usuarioCursointerface.actualizar(usuarioId, cursoId, nuevoUsuarioId, nuevoCursoId);
    }
    @DeleteMapping("/eliminar/{usuarioId}/{cursoId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public void eliminarUsuarioCurso(@PathVariable Integer usuarioId, @PathVariable Integer cursoId){
        usuarioCursointerface.eliminar(usuarioId, cursoId);
    }

    @GetMapping("/cursosDeUsuario/{codigoUsuario}")
    @PreAuthorize("hasRole('USER')")
    public List<CursosPorUsuarioDTO> cursosInscritosDeUsuario(@PathVariable Integer codigoUsuario){
        return usuarioCursointerface.listarCursosPorUsuario(codigoUsuario);
    }
}
