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
@Table(name = "socialaccount_socialaccount", indexes = {
        @Index(name = "socialaccount_socialaccount_provider_uid_fc810c6e_uniq", columnList = "provider, uid", unique = true),
        @Index(name = "socialaccount_socialaccount_user_id_8146e70c", columnList = "user_id")
})
public class SocialaccountSocialaccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "provider", nullable = false, length = 30)
    private String provider;

    @Size(max = 191)
    @NotNull
    @Column(name = "uid", nullable = false, length = 191)
    private String uid;

    @NotNull
    @Column(name = "last_login", nullable = false)
    private OffsetDateTime lastLogin;

    @NotNull
    @Column(name = "date_joined", nullable = false)
    private OffsetDateTime dateJoined;

    @NotNull
    @Column(name = "extra_data", nullable = false, columnDefinition = "TEXT")
    private String extraData;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
