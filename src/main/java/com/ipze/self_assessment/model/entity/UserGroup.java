package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "user_groups", indexes = {
        @Index(name = "user_groups_user_id_group_id_b88eab82_uniq", columnList = "user_id, group_id", unique = true),
        @Index(name = "user_groups_user_id_5f6f5a90", columnList = "user_id"),
        @Index(name = "user_groups_group_id_9afc8d0e", columnList = "group_id")
})
public class UserGroup {
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
    @JoinColumn(name = "group_id", nullable = false)
    private AuthGroup group;

}
