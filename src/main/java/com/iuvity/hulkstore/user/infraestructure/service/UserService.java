package com.iuvity.hulkstore.user.infraestructure.service;

import com.iuvity.hulkstore.user.domain.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity user);

    void remove(Long id);
}
