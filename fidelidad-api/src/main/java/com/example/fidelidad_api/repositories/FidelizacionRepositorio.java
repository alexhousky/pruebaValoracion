package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Fidelizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FidelizacionRepositorio extends JpaRepository<Fidelizacion, Long> {
    boolean existsByClienteIdAndMarcaId(Long clienteId, Long marcaId);
}
