package com.example.fidelidad_api.services;

import com.example.fidelidad_api.dtos.DepartamentoDTO;
import com.example.fidelidad_api.models.Departamento;
import com.example.fidelidad_api.repositories.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoServicio {

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    public List<DepartamentoDTO> listarPorPais(Long paisId) {
        return departamentoRepositorio.findByPaisId(paisId).stream()
                .map(dep -> new DepartamentoDTO(dep.getId(), dep.getNombre()))
                .collect(Collectors.toList());
    }
}


