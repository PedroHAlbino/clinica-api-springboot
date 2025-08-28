package com.albinos.clinica_api_springboot.dto;

import java.util.Date;

public record PacienteCreateDto(
        String nome,
        Date dataNascimento,
        String telefone
) {
}
