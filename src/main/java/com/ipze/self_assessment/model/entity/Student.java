package com.ipze.self_assessment.model.entity;

import com.ipze.self_assessment.model.BaseAuditableEntity;
import com.ipze.self_assessment.model.enums.Cycle;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "student", indexes = {
        @Index(name = "student_student_id_key", columnList = "student_id", unique = true),
        @Index(name = "student_user_id_key", columnList = "user_id", unique = true)
})
public class Student extends BaseAuditableEntity {

    @Column(name = "birthdate")
    private Date birthdate;

    @Size(max = 20)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Size(max = 255)
    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @Size(max = 15)
    @NotNull
    @Column(name = "student_id", nullable = false, length = 15)
    private String studentId;

    @NotNull
    @Column(name = "enrollment_date", nullable = false)
    private Date enrollmentDate;

    @NotNull
    @Column(name = "student_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Cycle cycle;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
