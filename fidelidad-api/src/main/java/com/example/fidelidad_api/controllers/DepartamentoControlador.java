package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.dtos.DepartamentoDTO;
import com.example.fidelidad_api.services.DepartamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoControlador {

    @Autowired
    private DepartamentoServicio departamentoServicio;

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> listarPorPais(@RequestParam Long paisId) {
        return ResponseEntity.ok(departamentoServicio.listarPorPais(paisId));
    }
}