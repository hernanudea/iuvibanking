package com.iuvity.hulkstore.user.infraestructure.service.impl;

import com.iuvity.hulkstore.user.domain.entities.CustomerEntity;
import com.iuvity.hulkstore.user.domain.repository.CustomerRepository;
import com.iuvity.hulkstore.user.infraestructure.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerEntity> findById(Long id) {
        return Optional.ofNullable(customerRepository.findById(id).orElse(null));
    }

    @Override
    public CustomerEntity save(CustomerEntity price) {
        return customerRepository.save(price);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
