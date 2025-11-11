package com.upc.cubegridlab.dtos;

import com.upc.cubegridlab.entidades.Proyecto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimulacionDTO {
    private Integer codigo;

    private String nombre;

    private LocalDate fechaCreacion;

    private BigDecimal costoTotal;

    private BigDecimal pesoTotal;

    private BigDecimal consumoTotal;

    private ProyectoDTO2 proyecto;
}
