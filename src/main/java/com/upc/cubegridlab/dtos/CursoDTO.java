package com.upc.cubegridlab.dtos;

import com.upc.cubegridlab.entidades.UsuarioCurso;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private Integer codigo;

    private String nombre;

    private String descripcion;
}
