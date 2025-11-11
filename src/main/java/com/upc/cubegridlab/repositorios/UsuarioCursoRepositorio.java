package com.upc.cubegridlab.repositorios;

import com.upc.cubegridlab.dtos.CursoDTO;
import com.upc.cubegridlab.dtos.CursosPorUsuarioDTO;
import com.upc.cubegridlab.dtos.UsuarioDTO;
import com.upc.cubegridlab.entidades.Curso;
import com.upc.cubegridlab.entidades.UsuarioCurso;
import com.upc.cubegridlab.entidades.UsuarioCursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioCursoRepositorio extends JpaRepository<UsuarioCurso, UsuarioCursoId> {
    @Query("SELECT new com.upc.cubegridlab.dtos.CursosPorUsuarioDTO(uc.usuario.codigo, uc.curso.codigo, uc.curso.nombre, uc.curso.descripcion) " +
            "FROM UsuarioCurso uc " +
            "WHERE uc.usuario.codigo = :codigoUsuario")
    List<CursosPorUsuarioDTO> cursosPorUsuario(@Param("codigoUsuario") Integer codigoUsuario);
}
