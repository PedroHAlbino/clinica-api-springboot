package com.albinos.clinica_api_springboot.controller;

import com.albinos.clinica_api_springboot.dto.MedicoResponseDto;
import com.albinos.clinica_api_springboot.dto.MedicosCadastroDto;
import com.albinos.clinica_api_springboot.mapper.MedicoMapper;
import com.albinos.clinica_api_springboot.model.Medico;
import com.albinos.clinica_api_springboot.repository.MedicosRepository;
import com.albinos.clinica_api_springboot.service.MedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/medicos")
public class MedicosController {

    @Autowired
    private MedicosService medicosService;

    @PostMapping
    public ResponseEntity<MedicosCadastroDto> cadastrar(@RequestBody MedicosCadastroDto novoMedico, UriComponentsBuilder builder) {
        Medico medico = medicosService.salvar(MedicoMapper.toMedico(novoMedico));
        var uri = builder.path("api/v1/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        MedicoResponseDto response = new MedicoResponseDto(
                MedicoMapper.toMedicoDto(medico),
                uri.toString()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response.medico());
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicosCadastroDto> buscar(@PathVariable Long id) {
       Medico medico = medicosService.buscar(id);
       return ResponseEntity.status(HttpStatus.OK).body(MedicoMapper.toMedicoDto(medico));
    }

    @PutMapping("{id}")
    public ResponseEntity<MedicosCadastroDto> atualizar(@PathVariable Long id, @RequestBody MedicosCadastroDto novoMedico) {
        medicosService.atualizar(id,novoMedico);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        medicosService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
