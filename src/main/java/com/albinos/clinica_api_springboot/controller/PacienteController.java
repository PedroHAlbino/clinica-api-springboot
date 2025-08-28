package com.albinos.clinica_api_springboot.controller;

import com.albinos.clinica_api_springboot.dto.PacienteCreateDto;
import com.albinos.clinica_api_springboot.dto.PacienteDto;
import com.albinos.clinica_api_springboot.dto.PacienteResponseDto;
import com.albinos.clinica_api_springboot.mapper.PacienteMappar;
import com.albinos.clinica_api_springboot.model.Paciente;
import com.albinos.clinica_api_springboot.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PacienteDto dto, UriComponentsBuilder builder) {
        Paciente paciente = pacienteService.salvar(PacienteMappar.toPaciente(dto));

        var uri = builder.path("api/v1/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        var response = new PacienteResponseDto(
                PacienteMappar.toDto(paciente), uri.toString()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response.paciente());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(PacienteMappar.toDto(paciente));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PacienteDto dto) {
        pacienteService.atualizar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        pacienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
