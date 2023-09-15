package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "user_permissions", indexes = {
        @Index(name = "user_permissions_user_id_permission_id_43338c45_uniq", columnList = "user_id, permission_id", unique = true),
        @Index(name = "user_permissions_user_id_20aca447", columnList = "user_id"),
        @Index(name = "user_permissions_permission_id_0b93982e", columnList = "permission_id")
})
public class UserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permission_id", nullable = false)
    private AuthPermission permission;

}
