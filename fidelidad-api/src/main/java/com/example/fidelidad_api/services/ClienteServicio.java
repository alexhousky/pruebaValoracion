package com.example.fidelidad_api.services;

import com.example.fidelidad_api.dtos.ClienteDTO;
import com.example.fidelidad_api.models.Cliente;
import com.example.fidelidad_api.repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public ClienteDTO guardarClienteYRetornarDTO(Cliente cliente) {
        Cliente guardado = clienteRepositorio.save(cliente);
        return convertirADTO(guardado);
    }

    public List<ClienteDTO> obtenerClientesDTO() {
        return clienteRepositorio.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
    }

    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }

    private ClienteDTO convertirADTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getTipoIdentificacion().getNombre(),
                cliente.getNumeroIdentificacion(),
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getCiudad().getNombre(),
                cliente.getDireccion()
        );
    }
}
