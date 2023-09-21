package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "flyway_schema_history", indexes = {
        @Index(name = "flyway_schema_history_s_idx", columnList = "success")
})
public class FlywaySchemaHistory {
    @Id
    @Column(name = "installed_rank", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "version", length = 50)
    private String version;

    @Size(max = 200)
    @NotNull
    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Size(max = 20)
    @NotNull
    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Size(max = 1000)
    @NotNull
    @Column(name = "script", nullable = false, length = 1000)
    private String script;

    @Column(name = "checksum")
    private Integer checksum;

    @Size(max = 100)
    @NotNull
    @Column(name = "installed_by", nullable = false, length = 100)
    private String installedBy;

    @NotNull
    @Column(name = "installed_on", nullable = false)
    private Instant installedOn;

    @NotNull
    @Column(name = "execution_time", nullable = false)
    private Integer executionTime;

    @NotNull
    @Column(name = "success", nullable = false)
    private Boolean success = false;

}
