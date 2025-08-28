package com.albinos.clinica_api_springboot.repository;

import com.albinos.clinica_api_springboot.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicosRepository extends JpaRepository<Medico, Long> {
}
