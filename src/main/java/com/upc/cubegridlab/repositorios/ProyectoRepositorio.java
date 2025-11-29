package com.upc.cubegridlab.repositorios;

import com.upc.cubegridlab.entidades.Proyecto;
import com.upc.cubegridlab.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProyectoRepositorio extends JpaRepository<Proyecto, Integer> {
    Optional<Proyecto> findByCodigo(Integer codigo);

}
