package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.dtos.RegistroFidelizacionDTO;
import com.example.fidelidad_api.models.Fidelizacion;
import com.example.fidelidad_api.services.FidelizacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fidelizacion")
@CrossOrigin(origins = "*")
public class FidelizacionControlador {

    @Autowired
    private FidelizacionServicio fidelizacionServicio;

    @PostMapping("/registrar")

    public ResponseEntity<Fidelizacion> registrar(@RequestBody RegistroFidelizacionDTO dto) {
        Fidelizacion fidelizacion = fidelizacionServicio.registrarFidelizacion(dto);
        return ResponseEntity.ok(fidelizacion);
    }
}
