package com.albinos.clinica_api_springboot.service;

import com.albinos.clinica_api_springboot.dto.MedicosCadastroDto;
import com.albinos.clinica_api_springboot.model.Medico;
import com.albinos.clinica_api_springboot.repository.MedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicosService {

    @Autowired
    private MedicosRepository medicosRepository;


    @Transactional
    public Medico salvar(Medico medico) {
       return medicosRepository.save(medico);
    }

    public Medico buscar(Long id) {
        return medicosRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Médico não encontrado com o id " + id)
        );
    }

    @Transactional
    public void atualizar(Long id, MedicosCadastroDto novoMedico) {
        Medico medico = buscar(id);
        medico.setNome(novoMedico.getNome());
        medico.setCrm(novoMedico.getCrm());
        medico.setEspecialidade(novoMedico.getEspecialidade());
        medicosRepository.save(medico);
    }

    public void deletar(Long id) {
        var existe = buscar(id);
        if (existe != null) {
            medicosRepository.deleteById(id);
        }
    }
}
