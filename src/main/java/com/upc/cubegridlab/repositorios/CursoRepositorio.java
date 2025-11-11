package com.upc.cubegridlab.repositorios;

import com.upc.cubegridlab.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CursoRepositorio extends JpaRepository<Curso, Integer> {
}
