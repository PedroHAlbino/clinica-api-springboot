package com.albinos.clinica_api_springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 120, nullable = false)
    private String nome;

    @Column(name = "crm", length = 20, nullable = false)
    private String crm;

    @Column(name = "especialidade", length = 60, nullable = false)
    private String especialidade;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "medico")
    private List<Consultas> consultas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consultas> consultas) {
        this.consultas = consultas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(id, medico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
