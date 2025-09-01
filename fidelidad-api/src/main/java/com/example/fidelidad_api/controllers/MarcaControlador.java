package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.dtos.MarcaDTO;
import com.example.fidelidad_api.services.MarcaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaControlador {

    @Autowired
    private MarcaServicio marcaServicio;

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> listarMarcas() {
        return ResponseEntity.ok(marcaServicio.listarTodas());
    }
}