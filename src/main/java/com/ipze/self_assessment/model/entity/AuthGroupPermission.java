package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "auth_group_permissions", indexes = {
        @Index(name = "auth_group_permissions_group_id_permission_id_0cd325b0_uniq", columnList = "group_id, permission_id", unique = true),
        @Index(name = "auth_group_permissions_group_id_b120cbf9", columnList = "group_id"),
        @Index(name = "auth_group_permissions_permission_id_84c5c92e", columnList = "permission_id")
})
public class AuthGroupPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private AuthGroup group;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permission_id", nullable = false)
    private AuthPermission permission;

}
