package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "public", indexes = {
        @Index(name = "user_username_key", columnList = "username", unique = true),
        @Index(name = "user_username_06e46fe6_like", columnList = "username")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 128)
    @NotNull
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    @NotNull
    @Column(name = "is_superuser", nullable = false)
    private Boolean isSuperuser = false;

    @Size(max = 150)
    @NotNull
    @Column(name = "username", nullable = false, length = 150)
    private String username;

    @Size(max = 254)
    @NotNull
    @Column(name = "email", nullable = false, length = 254)
    private String email;

    @NotNull
    @Column(name = "is_staff", nullable = false)
    private Boolean isStaff = false;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @NotNull
    @Column(name = "date_joined", nullable = false)
    private OffsetDateTime dateJoined;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "user")
    private Teacher teacher;

    @OneToOne(mappedBy = "user")
    private AuthtokenToken authtokenToken;

    @OneToOne(mappedBy = "user")
    private Student student;

    @OneToMany(mappedBy = "user")
    private Set<UserGroup> userGroups = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserPermission> userPermissions = new LinkedHashSet<>();

}
