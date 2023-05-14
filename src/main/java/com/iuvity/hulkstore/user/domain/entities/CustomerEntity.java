package com.iuvity.hulkstore.user.domain.entities;

import com.iuvity.hulkstore.product.domain.entities.KardexEntity;
import com.iuvity.hulkstore.product.domain.entities.ShoppingCartEntity;
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
@Entity(name = "customers")
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String creditCard;
    private LocalDate birthday;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false, unique = false)
    private String email;
    private String createdUser;

    //    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer"
    )
    private Set<KardexEntity> kardexs;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer"
    )
    private Set<ShoppingCartEntity> shoppingCart;
}
