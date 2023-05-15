package com.iuvity.hulkstore.product.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iuvity.hulkstore.user.domain.entities.CustomerEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shopping_carts")
public class ShoppingCartEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Integer newBalance;
    @Column(nullable = false)
    private Integer cant;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String createdUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "price_id")
    @JsonIgnore
    private PriceEntity price;


}
