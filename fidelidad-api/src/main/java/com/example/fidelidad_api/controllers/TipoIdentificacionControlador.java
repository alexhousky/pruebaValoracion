package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.TipoIdentificacion;
import com.example.fidelidad_api.services.TipoIdentificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tipos-identificacion")
public class TipoIdentificacionControlador {

    @Autowired
    private TipoIdentificacionServicio tipoIdentificacionServicio;

    @GetMapping
    public ResponseEntity<?> listarTiposIdentificacion() {
        try {
            List<TipoIdentificacion> tipos = tipoIdentificacionServicio.listarTodos();
            return ResponseEntity.ok(tipos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al listar tipos de identificación: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTipoIdentificacion(@PathVariable Long id) {
        try {
            TipoIdentificacion tipo = tipoIdentificacionServicio.obtenerPorId(id);
            return ResponseEntity.ok(tipo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tipo de identificación no encontrado con id: " + id);
        }
    }
}


