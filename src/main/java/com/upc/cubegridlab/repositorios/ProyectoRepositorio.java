package com.upc.cubegridlab.repositorios;

import com.upc.cubegridlab.entidades.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepositorio extends JpaRepository<Proyecto, Integer> {
}
