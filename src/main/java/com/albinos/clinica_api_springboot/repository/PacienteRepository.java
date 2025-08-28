package com.albinos.clinica_api_springboot.repository;

import com.albinos.clinica_api_springboot.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
