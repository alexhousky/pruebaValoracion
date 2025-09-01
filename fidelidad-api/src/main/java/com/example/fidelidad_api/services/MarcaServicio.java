package com.example.fidelidad_api.services;

import com.example.fidelidad_api.dtos.MarcaDTO;
import com.example.fidelidad_api.models.Marca;
import com.example.fidelidad_api.repositories.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaServicio {

    @Autowired
    private MarcaRepositorio marcaRepositorio;

    public List<MarcaDTO> listarTodas() {
        List<Marca> marcas = marcaRepositorio.findAll();
        return marcas.stream()
                .map(marca -> new MarcaDTO(marca.getId(), marca.getNombre()))
                .collect(Collectors.toList());
    }
}

