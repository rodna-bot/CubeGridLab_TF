package com.upc.cubegridlab.interfaces;

import com.upc.cubegridlab.dtos.ProyectoDTO;

import java.util.List;

public interface IProyectoComponente {
    public Integer registrar(Integer ProyectoId, Integer componenteId);
    public Integer actualizar(Integer ProyectoId, Integer componenteId, Integer nuevoIdProyecto, Integer nuevoIdComponente);
    public void eliminar(Integer ProyectoId, Integer componenteId);
    public List<ProyectoDTO> listar();
}
