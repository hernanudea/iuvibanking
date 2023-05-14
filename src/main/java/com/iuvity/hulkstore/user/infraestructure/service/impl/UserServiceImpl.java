package com.iuvity.hulkstore.user.infraestructure.service.impl;

import com.iuvity.hulkstore.user.domain.entities.UserEntity;
import com.iuvity.hulkstore.user.domain.repository.UserRepository;
import com.iuvity.hulkstore.user.infraestructure.service.UserService;
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
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return userRepository.save(user);
    }
}
