package com.albinos.clinica_api_springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "consultas")
public class Consultas  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Column(name = "data_hora", nullable = false)
    private LocalDate dataHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50, nullable = false)
    private Status status;

    @Column(name = "observacao", length = 500, nullable = false)
    private String observacao;

}