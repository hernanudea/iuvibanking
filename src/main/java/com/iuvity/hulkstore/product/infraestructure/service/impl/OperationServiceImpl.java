package com.iuvity.hulkstore.product.infraestructure.service.impl;

import com.iuvity.hulkstore.product.domain.entities.OperationEntity;
import com.iuvity.hulkstore.product.domain.repositories.OperationRepository;
import com.iuvity.hulkstore.product.infraestructure.service.OperationService;
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
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<OperationEntity> findAll() {
        return operationRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OperationEntity> findById(Long id) {
        return Optional.ofNullable(operationRepository.findById(id).orElse(null));
    }

    @Override
    public OperationEntity save(OperationEntity operation) {
        return operationRepository.save(operation);
    }

    @Override
    public void remove(Long id) {
        operationRepository.deleteById(id);
    }

}
