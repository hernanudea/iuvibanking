package com.iuvity.hulkstore.user.domain.repository;

import com.iuvity.hulkstore.user.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
