package com.upc.cubegridlab.controllers;

import com.upc.cubegridlab.dtos.NanosateliteDTO;
import com.upc.cubegridlab.interfaces.INanosatelite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/nanosatelite")
public class NanosateliteController {
    @Autowired
    INanosatelite service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<NanosateliteDTO> listar(){ return service.listar(); }

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<NanosateliteDTO> crear(@RequestBody NanosateliteDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(dto));
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public NanosateliteDTO actualizar( @RequestBody NanosateliteDTO dto){
        return service.actualizar(dto);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
