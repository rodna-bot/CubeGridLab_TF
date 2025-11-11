package com.upc.cubegridlab.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "simulaciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Simulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "costo_total", nullable = false)
    private BigDecimal costoTotal;

    @Column(name = "peso_total", nullable = false, precision = 6, scale = 2)
    private BigDecimal pesoTotal;

    @Column(name = "consumo_total", nullable = false, precision = 6, scale = 2)
    private BigDecimal consumoTotal;

    @OneToOne
    @JoinColumn(name = "codigo_proyecto", nullable = false, unique = true)
    private Proyecto proyecto;
}
