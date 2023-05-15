package com.iuvity.hulkstore.user.infraestructure.service;

import com.iuvity.hulkstore.user.domain.entities.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerEntity> findAll();

    Optional<CustomerEntity> findById(Long id);

    CustomerEntity save(CustomerEntity price);

    void remove(Long id);

}
