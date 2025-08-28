package com.albinos.clinica_api_springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pacientes")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date dataNascimento;

    private String telefone;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Consultas> consultas;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
