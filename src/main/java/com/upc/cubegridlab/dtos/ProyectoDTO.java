package com.upc.cubegridlab.dtos;

import com.upc.cubegridlab.entidades.Componente;
import com.upc.cubegridlab.entidades.Curso;
import com.upc.cubegridlab.entidades.Simulacion;
import com.upc.cubegridlab.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO {
    private Integer codigo;

    private String nombre;
    private String descripcion;

    private LocalDate fecha_creacion;

    private UsuarioDTO cod_usuario;

    private CursoDTO cod_curso;

    private NanosateliteDTO cod_nanosatelite;
    private List<ComponenteDTO> componentes;
}
