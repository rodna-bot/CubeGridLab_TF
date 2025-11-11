package com.upc.cubegridlab.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "nanosatelites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Nanosatelite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(length = 30, nullable = false)
    private String tipo;

    @Column(nullable = false)
    private BigDecimal precio;

    @OneToMany(mappedBy = "nanosatelite")
    private List<Proyecto> proyectos = new ArrayList<>();
}
