package com.albinos.clinica_api_springboot.dto;


import java.util.Date;

public record PacienteDto(
        String nome,
        Date dataNascimento,
        String telefone
) {


}
