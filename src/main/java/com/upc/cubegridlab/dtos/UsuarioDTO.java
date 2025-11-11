package com.upc.cubegridlab.dtos;

import com.upc.cubegridlab.entidades.UsuarioCurso;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer codigo;

    private String username;

    private String password;
}
