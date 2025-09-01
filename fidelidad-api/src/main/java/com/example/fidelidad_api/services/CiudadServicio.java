package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Ciudad;
import com.example.fidelidad_api.repositories.CiudadRepositorio;
import com.example.fidelidad_api.dtos.CiudadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CiudadServicio {

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    public List<CiudadDTO> listarPorDepartamento(Long departamentoId) {
        return ciudadRepositorio.findByDepartamentoId(departamentoId).stream()
                .map(ciudad -> new CiudadDTO(ciudad.getId(), ciudad.getNombre()))
                .collect(Collectors.toList());
    }

    public Ciudad obtenerPorId(Long id) {
        Optional<Ciudad> ciudad = ciudadRepositorio.findById(id);
        return ciudad.orElseThrow(() -> new RuntimeException("Ciudad no encontrada con id: " + id));
    }
}





