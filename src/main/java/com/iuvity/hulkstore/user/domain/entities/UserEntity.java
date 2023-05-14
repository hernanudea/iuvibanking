package com.iuvity.hulkstore.user.domain.entities;

import com.iuvity.hulkstore.util.AvailabilityEnum;
import com.iuvity.hulkstore.util.RoleEmun;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    private AvailabilityEnum availability;
    private RoleEmun role;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long createdUser;
    private Long updatedUser;

}
