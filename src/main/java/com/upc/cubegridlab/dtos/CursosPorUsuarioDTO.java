package com.upc.cubegridlab.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CursosPorUsuarioDTO {
    private Integer codigoUsuario;
    private Integer codigoCurso;
    private String nombre;
    private String descripcion;
}
