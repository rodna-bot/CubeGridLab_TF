package com.upc.cubegridlab.controllers;

import com.upc.cubegridlab.dtos.CursoDTO;
import com.upc.cubegridlab.dtos.NanosateliteDTO;
import com.upc.cubegridlab.dtos.ProyectoDTO;
import com.upc.cubegridlab.interfaces.IProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {
@Autowired
    IProyecto proyecto;
    @PostMapping("/registrar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ProyectoDTO registrarProyecto(@RequestBody ProyectoDTO proyectoDTO){
        return proyecto.registrar(proyectoDTO);
    }
    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ProyectoDTO actualizarProyecto(@RequestBody ProyectoDTO proyectoDTO){
        return proyecto.actualizar(proyectoDTO);
    }
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public void eliminarProyecto(@PathVariable Integer id){
        proyecto.eliminar(id);
    }
    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<ProyectoDTO> listar(){
        return proyecto.listar();
    }

}
