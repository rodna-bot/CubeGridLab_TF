package com.upc.cubegridlab.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios_cursos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCurso {
    @EmbeddedId
    private UsuarioCursoId id;

    @ManyToOne
    @MapsId("codigoUsuario")
    @JoinColumn(name = "codigo_usuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("codigoCurso")
    @JoinColumn(name = "codigo_curso")
    private Curso curso;
}
