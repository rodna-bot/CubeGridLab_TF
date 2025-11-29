package com.upc.cubegridlab.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proyectos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha_creacion;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo_usuario"),
            @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso")
    })
    private UsuarioCurso usuarioCurso;

    @ManyToOne
    @JoinColumn(name = "codigo_nanosatelite", nullable = true)
    private Nanosatelite nanosatelite;

    //@ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "proyectos_componentes",
            joinColumns = @JoinColumn(name = "codigo_proyecto"),
            inverseJoinColumns = @JoinColumn(name = "codigo_componente")
    )
    private Set<Componente> componentes = new HashSet<>();
}