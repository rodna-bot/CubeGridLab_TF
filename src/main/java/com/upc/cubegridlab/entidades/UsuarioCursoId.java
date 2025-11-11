package com.upc.cubegridlab.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioCursoId implements Serializable {
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @Column(name = "codigo_curso")
    private Integer codigoCurso;
}
