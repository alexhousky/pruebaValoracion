package com.example.fidelidad_api.services;

import com.example.fidelidad_api.dtos.RegistroFidelizacionDTO;
import com.example.fidelidad_api.models.Cliente;
import com.example.fidelidad_api.models.Fidelizacion;
import com.example.fidelidad_api.models.Marca;
import com.example.fidelidad_api.repositories.ClienteRepositorio;
import com.example.fidelidad_api.repositories.FidelizacionRepositorio;
import com.example.fidelidad_api.repositories.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FidelizacionServicio {

    @Autowired
    private FidelizacionRepositorio fidelizacionRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private MarcaRepositorio marcaRepositorio;

    public Fidelizacion registrarFidelizacion(RegistroFidelizacionDTO dto) {
        if (fidelizacionRepositorio.existsByClienteIdAndMarcaId(dto.getClienteId(), dto.getMarcaId())) {
            throw new RuntimeException("El cliente ya está registrado en esta marca.");
        }

        Cliente cliente = clienteRepositorio.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Marca marca = marcaRepositorio.findById(dto.getMarcaId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));

        Fidelizacion fidelizacion = new Fidelizacion();
        fidelizacion.setCliente(cliente);
        fidelizacion.setMarca(marca);
        fidelizacion.setFechaInicio(dto.getFechaInicio());
        fidelizacion.setEstado("activo");

        return fidelizacionRepositorio.save(fidelizacion);
    }
}
