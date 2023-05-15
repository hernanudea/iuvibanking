package com.iuvity.hulkstore.product.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.iuvity.hulkstore.util.AvailabilityEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "prices")
public class PriceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private AvailabilityEnum availability;  // toDo
    private String availability;
    private String category;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private LocalDateTime initialEffectiveDate;
    @Column(nullable = false)
    private LocalDateTime endEffectiveDate;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String createdUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private ProductEntity productId;

//    @JsonBackReference
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
//            orphanRemoval = true,
//            mappedBy = "price"
//    )
//    private List<KardexEntity> kardexs;

//    @JsonBackReference
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
//            orphanRemoval = true,
//            mappedBy = "price"
//    )
//    private List<ShoppingCartEntity> shoppingCart;
}
