package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {
    List<Departamento> findByPaisId(Long paisId);
}
