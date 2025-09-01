package com.example.fidelidad_api.services;

import com.example.fidelidad_api.dtos.PaisDTO;
import com.example.fidelidad_api.models.Pais;
import com.example.fidelidad_api.repositories.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisServicio {

    @Autowired
    private PaisRepositorio paisRepositorio;

    public List<PaisDTO> listarTodos() {
        return paisRepositorio.findAll().stream()
                .map(pais -> new PaisDTO(pais.getId(), pais.getNombre()))
                .collect(Collectors.toList());
    }
}


