package com.upc.cubegridlab.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComponenteDTO {
    private  Integer codigo;
    private  String nombre;
    private  String descripcion;
    private  String tipo;
    private BigDecimal precio;
    private BigDecimal peso;
    private BigDecimal consumo;
}
