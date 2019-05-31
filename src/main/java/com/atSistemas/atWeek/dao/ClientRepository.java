package com.atSistemas.atWeek.dao;

import com.atSistemas.atWeek.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByDni(String dni);
}
