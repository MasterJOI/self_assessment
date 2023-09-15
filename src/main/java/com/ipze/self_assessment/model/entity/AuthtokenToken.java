package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "authtoken_token", indexes = {
        @Index(name = "authtoken_token_user_id_key", columnList = "user_id", unique = true)
})
public class AuthtokenToken {
    @Id
    @Size(max = 40)
    @Column(name = "key", nullable = false, length = 40)
    private String key;

    @NotNull
    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
