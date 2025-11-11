package com.upc.cubegridlab.interfaces;

import com.upc.cubegridlab.dtos.ProyectoDTO;
import com.upc.cubegridlab.dtos.SimulacionDTO;

import java.util.List;

public interface ISimulacion {
    public SimulacionDTO registrar(SimulacionDTO simulacionDTO);
    public SimulacionDTO actualizar(SimulacionDTO simulacionDTO);
    public void eliminar(Integer id);
    public List<SimulacionDTO> listar();
}
