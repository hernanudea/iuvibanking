package com.iuvity.hulkstore.product.domain.repositories;

import com.iuvity.hulkstore.product.domain.entities.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {
}
