package com.portfolio.pagamentosapi.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cobranca")
@Data
public class Cobranca {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String cliente;
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusCobranca status;

    private LocalDateTime dataCriacao;
    private String referenciaExterna;

}
