package com.albinos.clinica_api_springboot.dto;

public record PacienteResponseDto(
        PacienteDto paciente,
        String location
) {



}
