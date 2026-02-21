package com.proyecto.retiro.repositorio;

import com.proyecto.retiro.modelo.Retiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetiroRepositorio extends JpaRepository<Retiro, Long> {
    // Spring Data JPA ya proporciona: save, findAll, findById, deleteById
}