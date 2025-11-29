package com.upc.cubegridlab.controllers;

import com.upc.cubegridlab.dtos.ProyectoDTO;
import com.upc.cubegridlab.dtos.ReporteDTO;
import com.upc.cubegridlab.dtos.SimulacionDTO;
import com.upc.cubegridlab.dtos.SimulacionDTO2;
import com.upc.cubegridlab.interfaces.ISimulacion;
import com.upc.cubegridlab.service.SimulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api/simulacion")
public class SimulacionController {
    @Autowired
    private ISimulacion simulacion;

    @PostMapping("/registrar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<SimulacionDTO> registrarSimulacion(@RequestBody SimulacionDTO simulacionDTO){
        return ResponseEntity.ok(simulacion.registrar(simulacionDTO));
    }
    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public SimulacionDTO actualizarSimulacion(@RequestBody SimulacionDTO simulacionDTO){
        return simulacion.actualizar(simulacionDTO);
    }
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public void eliminarSimulacion(@PathVariable Integer id){
        simulacion.eliminar(id);
    }
    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<SimulacionDTO> listar(){
        return simulacion.listar();
    }

    @GetMapping("/buscar/{codigoProyecto}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public SimulacionDTO2 buscarSimulacionPorCodigoProyecto(@PathVariable Integer codigoProyecto){
        return simulacion.buscarSimulacionPorCodigoProyecto(codigoProyecto);
    }

    @GetMapping("/reporte/{codigoUsuario}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<ReporteDTO> obtenerPromedios(@PathVariable Integer codigoUsuario) {
        ReporteDTO reporte = simulacion.obtenerPromediosPorUsuario(codigoUsuario);
        return ResponseEntity.ok(reporte);
    }
}
