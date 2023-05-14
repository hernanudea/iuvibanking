package com.iuvity.hulkstore.product.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullName;
    private String description;
    private String brand;
    private String category;
    private String supplier;
    private String weight;
    private String dimension;
    private String barcode;
    private String availability;
    private int rating;
    private String imageUrl;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    private String createdUser;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "productId"
    )
    private Set<PriceEntity> prices;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "product"
    )
    private Set<KardexEntity> kardexs;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private StockEntity stock;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "product"
    )
    private Set<ShoppingCartEntity> shoppingCart;
}
