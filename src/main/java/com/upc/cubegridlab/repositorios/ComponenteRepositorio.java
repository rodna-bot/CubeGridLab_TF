package com.upc.cubegridlab.repositorios;

import com.upc.cubegridlab.entidades.Componente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponenteRepositorio extends JpaRepository<Componente, Integer> {
}
