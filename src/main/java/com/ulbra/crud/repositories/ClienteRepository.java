package com.ulbra.crud.repositories;

import com.ulbra.crud.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
