package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "auth_group", indexes = {
        @Index(name = "auth_group_name_key", columnList = "name", unique = true)
})
public class AuthGroup extends BaseAuditableEntity {

    @Size(max = 150)
    @NotNull
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @ManyToMany
    @JoinTable(name = "auth_group_authPermissions",
            joinColumns = @JoinColumn(name = "authGroup_id"),
            inverseJoinColumns = @JoinColumn(name = "authPermissions_id"))
    private Set<AuthPermission> authPermissions = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "authGroups")
    private Set<User> users = new LinkedHashSet<>();

}
