package com.albinos.clinica_api_springboot.dto;

public record MedicoResponseDto(
        MedicosCadastroDto medico,
        String uri
) {
}
