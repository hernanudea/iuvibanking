package com.iuvity.hulkstore.product.domain.repositories;

import com.iuvity.hulkstore.product.domain.entities.KardexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KardexRepository extends JpaRepository<KardexEntity, Long> {
}
