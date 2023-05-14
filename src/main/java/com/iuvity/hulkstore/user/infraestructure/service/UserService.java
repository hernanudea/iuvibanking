package com.iuvity.hulkstore.user.infraestructure.service;

import com.iuvity.hulkstore.user.domain.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity user);

    void remove(Long id);
}
