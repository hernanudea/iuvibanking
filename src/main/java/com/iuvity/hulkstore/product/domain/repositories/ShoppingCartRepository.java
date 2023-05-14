package com.iuvity.hulkstore.product.domain.repositories;

import com.iuvity.hulkstore.product.domain.entities.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {
}
