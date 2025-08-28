package com.albinos.clinica_api_springboot.service;

import com.albinos.clinica_api_springboot.dto.PacienteDto;
import com.albinos.clinica_api_springboot.model.Paciente;
import com.albinos.clinica_api_springboot.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    @Transactional
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Transactional(readOnly = true)
    public Paciente buscar(Long id) {
        return pacienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Paciente não encontrato como id " + id)
        );
    }

    @Transactional
    public void atualizar(Long id, PacienteDto dto) {
        Paciente paciente = buscar(id);
        paciente.setNome(dto.nome());
        paciente.setTelefone(dto.telefone());
        paciente.setDataNascimento(dto.dataNascimento());
        pacienteRepository.save(paciente);

    }

    public void deletar(Long id) {
        buscar(id);
        pacienteRepository.deleteById(id);
    }
}
