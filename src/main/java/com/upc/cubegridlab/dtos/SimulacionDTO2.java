package com.upc.cubegridlab.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimulacionDTO2 {
    private Integer codigo;

    private String nombre;

    private LocalDate fechaCreacion;

    private BigDecimal costoTotal;

    private BigDecimal pesoTotal;

    private BigDecimal consumoTotal;
}
