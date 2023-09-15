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
@Table(name = "auth_group", indexes = {
        @Index(name = "auth_group_name_key", columnList = "name", unique = true),
        @Index(name = "auth_group_name_a6ea08ec_like", columnList = "name")
})
public class AuthGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 150)
    @NotNull
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @OneToMany(mappedBy = "group")
    private Set<AuthGroupPermission> authGroupPermissions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "group")
    private Set<UserGroup> userGroups = new LinkedHashSet<>();

}
