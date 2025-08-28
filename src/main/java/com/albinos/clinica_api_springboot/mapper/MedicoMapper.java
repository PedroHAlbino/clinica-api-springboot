package com.albinos.clinica_api_springboot.mapper;

import com.albinos.clinica_api_springboot.dto.MedicosCadastroDto;
import com.albinos.clinica_api_springboot.model.Medico;
import org.modelmapper.ModelMapper;

public class MedicoMapper {

    public static Medico toMedico(MedicosCadastroDto novoMedicoDto) {
        Medico medico = new Medico();
        medico.setNome(novoMedicoDto.getNome());
        medico.setCrm(novoMedicoDto.getCrm());
        medico.setEspecialidade(novoMedicoDto.getEspecialidade());
        return medico;
    }

    public static MedicosCadastroDto toMedicoDto(Medico medico) {
        return new ModelMapper().map(medico, MedicosCadastroDto.class);
    }

}
