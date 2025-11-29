package com.upc.cubegridlab.controllers;

import com.upc.cubegridlab.dtos.CursoDTO;
import com.upc.cubegridlab.dtos.UsuarioDTO;
import com.upc.cubegridlab.interfaces.ICurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    ICurso curso;
    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ADMIN')")
    public CursoDTO registrarCurso(@RequestBody CursoDTO cursoDTO){
        return curso.registrar(cursoDTO);
    }
    @PutMapping("/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public CursoDTO actualizarCurso(@RequestBody CursoDTO cursoDTO){
        return curso.actualizar(cursoDTO);
    }
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarCurso(@PathVariable Integer id){
        curso.eliminar(id);
    }
    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<CursoDTO> listar(){
        return curso.listar();
    }

}
