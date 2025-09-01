package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.dtos.PaisDTO;
import com.example.fidelidad_api.models.Pais;
import com.example.fidelidad_api.repositories.PaisRepositorio;
import com.example.fidelidad_api.services.PaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaisControlador {

    @Autowired
    private PaisRepositorio paisRepository;

    @GetMapping("/paises")
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }
}


