package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.dtos.CiudadDTO;
import com.example.fidelidad_api.services.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadControlador {

    @Autowired
    private CiudadServicio ciudadServicio;

    @GetMapping
    public ResponseEntity<List<CiudadDTO>> listarPorDepartamento(@RequestParam Long departamentoId) {
        return ResponseEntity.ok(ciudadServicio.listarPorDepartamento(departamentoId));
    }
}