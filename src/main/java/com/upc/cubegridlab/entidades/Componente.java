package com.upc.cubegridlab.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "componentes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Componente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 30, nullable = false)
    private String tipo;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal peso;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal consumo;
}
