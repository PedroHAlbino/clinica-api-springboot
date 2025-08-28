package com.albinos.clinica_api_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicosCadastroDto {
    private String nome;
    private String crm;
    private String especialidade;
}
