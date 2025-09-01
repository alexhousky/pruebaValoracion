package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Long> { }


