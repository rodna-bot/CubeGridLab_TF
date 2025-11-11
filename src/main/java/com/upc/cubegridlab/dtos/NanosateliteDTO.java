package com.upc.cubegridlab.dtos;

import com.upc.cubegridlab.entidades.Componente;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class NanosateliteDTO {
        private Integer codigo;
        private String  tipo;
        private BigDecimal precio;
}
