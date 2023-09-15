package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "auth_permission", indexes = {
        @Index(name = "auth_permission_codename_01ab375a_uniq", columnList = "codename", unique = true),
})
public class AuthPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 100)
    @NotNull
    @Column(name = "codename", nullable = false, length = 100)
    private String codename;

    @OneToMany(mappedBy = "permission")
    private Set<AuthGroupPermission> authGroupPermissions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "permission")
    private Set<UserPermission> userPermissions = new LinkedHashSet<>();

}
