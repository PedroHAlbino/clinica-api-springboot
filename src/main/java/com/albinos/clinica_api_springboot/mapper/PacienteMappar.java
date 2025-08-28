package com.albinos.clinica_api_springboot.mapper;

import com.albinos.clinica_api_springboot.dto.PacienteDto;
import com.albinos.clinica_api_springboot.model.Paciente;
import org.modelmapper.ModelMapper;

public class PacienteMappar {

    private static ModelMapper modelMapper = new ModelMapper();


    public static Paciente toPaciente(PacienteDto createDto) {
        var paciente = new Paciente();
        paciente.setNome(createDto.nome());
        paciente.setDataNascimento(createDto.dataNascimento());
        paciente.setTelefone(createDto.telefone());
        return paciente;
    }

    public static PacienteDto toDto(Paciente paciente) {
        return new PacienteDto(

                paciente.getNome(),
                paciente.getDataNascimento(),
                paciente.getTelefone()
        );
    }
}
