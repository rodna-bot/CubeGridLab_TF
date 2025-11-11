package com.upc.cubegridlab.interfaces;

import com.upc.cubegridlab.dtos.ComponenteDTO;
import com.upc.cubegridlab.dtos.CursoDTO;

import java.util.List;

public interface IComponente {
    public ComponenteDTO registrar(ComponenteDTO componente);
    public ComponenteDTO actualizar(ComponenteDTO componente);
    public void eliminar(Integer id);
    public List<ComponenteDTO> listar();
}
