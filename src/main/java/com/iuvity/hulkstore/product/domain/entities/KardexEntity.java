package com.iuvity.hulkstore.product.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "kardex")
public class KardexEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer cant;

    @Column(nullable = false)
    private Integer newBalance;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String createdUser;

}

