package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {}


