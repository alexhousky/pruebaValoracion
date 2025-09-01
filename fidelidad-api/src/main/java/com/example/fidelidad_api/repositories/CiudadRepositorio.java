package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CiudadRepositorio extends JpaRepository<Ciudad, Long> {
    List<Ciudad> findByDepartamentoId(Long departamentoId);
}


