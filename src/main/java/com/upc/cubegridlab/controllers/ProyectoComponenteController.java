package com.upc.cubegridlab.controllers;

import com.upc.cubegridlab.dtos.ProyectoDTO;
import com.upc.cubegridlab.interfaces.IProyectoComponente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ProyectoComponente")
public class ProyectoComponenteController {
    @Autowired
    IProyectoComponente proyectoComponente;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<ProyectoDTO> listar(){ return proyectoComponente.listar(); }

    @PostMapping("/registrar/{proyectoId}/{componenteId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Integer> crear(@PathVariable Integer proyectoId, @PathVariable Integer componenteId){
        return ResponseEntity.ok(proyectoComponente.registrar(proyectoId, componenteId));
    }

    @PutMapping("/actualizar/{proyectoId}/{componenteId}/{nuevoIdProyecto}/{nuevoIdComponente}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Integer> actualizar(@PathVariable Integer proyectoId, @PathVariable Integer componenteId,@PathVariable Integer nuevoIdProyecto, @PathVariable Integer nuevoIdComponente){
        return ResponseEntity.ok(proyectoComponente.actualizar(proyectoId, componenteId, nuevoIdProyecto, nuevoIdComponente));
    }

    @DeleteMapping("/eliminar/{proyectoId}/{componenteId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public void eliminar(@PathVariable Integer proyectoId, @PathVariable Integer componenteId){
        proyectoComponente.eliminar(proyectoId, componenteId);
    }
}
