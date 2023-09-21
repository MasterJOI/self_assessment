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
@Table(name = "auth_permission", indexes = {
        @Index(name = "auth_permission_codename_01ab375a_uniq", columnList = "codename", unique = true),
})
public class AuthPermission extends BaseAuditableEntity {

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 100)
    @NotNull
    @Column(name = "codename", nullable = false, length = 100)
    private String codename;

    @ManyToMany(mappedBy = "authPermissions")
    private Set<User> users = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "authPermissions")
    private Set<AuthGroup> authGroups = new LinkedHashSet<>();

}
