package com.iuvity.hulkstore.product.domain.repositories;

import com.iuvity.hulkstore.product.domain.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
}
