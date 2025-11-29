package com.upc.cubegridlab.controllers;

import com.upc.cubegridlab.dtos.ComponenteDTO;
import com.upc.cubegridlab.dtos.NanosateliteDTO;
import com.upc.cubegridlab.interfaces.IComponente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api/componente")
public class ComponenteController {
    @Autowired
    IComponente componente;

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ComponenteDTO> crear(@RequestBody ComponenteDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(componente.registrar(dto));}

    @PutMapping("/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ComponenteDTO actualizar( @RequestBody ComponenteDTO dto){
        return componente.actualizar(dto);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        componente.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<ComponenteDTO> listar(){ return componente.listar(); }
}
