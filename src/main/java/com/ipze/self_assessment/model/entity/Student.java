package com.ipze.self_assessment.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student", indexes = {
        @Index(name = "student_student_id_key", columnList = "student_id", unique = true),
        @Index(name = "student_user_id_key", columnList = "user_id", unique = true),
        @Index(name = "student_student_id_53c349bf_like", columnList = "student_id")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Size(max = 15)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 15)
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
    private LocalDate enrollmentDate;

    @NotNull
    @Column(name = "student_type", nullable = false)
    private Integer studentType;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
