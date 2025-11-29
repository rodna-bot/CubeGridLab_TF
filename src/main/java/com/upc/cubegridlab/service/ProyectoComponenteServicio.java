package com.upc.cubegridlab.service;

import com.upc.cubegridlab.dtos.ProyectoDTO;
import com.upc.cubegridlab.entidades.Componente;
import com.upc.cubegridlab.entidades.Proyecto;
import com.upc.cubegridlab.interfaces.IProyectoComponente;
import com.upc.cubegridlab.repositorios.ComponenteRepositorio;
import com.upc.cubegridlab.repositorios.ProyectoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyectoComponenteServicio implements IProyectoComponente {
    @Autowired
    ProyectoRepositorio proyectoRepositorio;
    @Autowired
    ComponenteRepositorio componenteRepositorio;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Integer registrar(Integer proyectoId, Integer componenteId) {
        Proyecto proyecto = proyectoRepositorio.findById(proyectoId).orElse(null);
        Componente componente = componenteRepositorio.findById(componenteId).orElse(null);
        if (proyecto != null && componente != null) {
            proyecto.getComponentes().add(componente);
            proyectoRepositorio.save(proyecto);
            componenteRepositorio.save(componente);
            return 1;
        }
        return null;
    }

    @Override
    public Integer actualizar(Integer proyectoId, Integer componenteId, Integer nuevoIdProyecto, Integer nuevoIdComponente) {
        Proyecto proyecto = proyectoRepositorio.findById(proyectoId).orElse(null);
        Componente componente = componenteRepositorio.findById(componenteId).orElse(null);

        Proyecto nuevoProyecto = proyectoRepositorio.findById(nuevoIdProyecto).orElse(null);
        Componente nuevoComponente = componenteRepositorio.findById(nuevoIdComponente).orElse(null);

        if (proyecto != null && componente != null && nuevoProyecto != null && nuevoComponente != null) {
            if (proyecto.getComponentes().contains(componente)) {
                proyecto.getComponentes().remove(componente);
            }

            if (!nuevoProyecto.getComponentes().contains(nuevoComponente)) {
                nuevoProyecto.getComponentes().add(nuevoComponente);
            }

            proyectoRepositorio.save(proyecto);
            componenteRepositorio.save(nuevoComponente);
            proyectoRepositorio.save(nuevoProyecto);
            return 1;
        }
        return null;
    }

    @Override
    public void eliminar(Integer proyectoId, Integer componenteId) {
        Proyecto proyecto = proyectoRepositorio.findById(proyectoId).orElse(null);
        Componente componente = componenteRepositorio.findById(componenteId).orElse(null);

        if (proyecto != null && componente != null) {
            proyecto.getComponentes().remove(componente);
            proyectoRepositorio.save(proyecto);
        }
    }

    @Override
    public List<ProyectoDTO> listar() {
        return proyectoRepositorio.findAll().stream()
                .map(proyecto -> modelMapper.map(proyecto, ProyectoDTO.class))
                .collect(Collectors.toList());
    }

}
