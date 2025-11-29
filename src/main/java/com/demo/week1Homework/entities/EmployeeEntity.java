package com.demo.week1Homework.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity                      // ✅ REQUIRED
@Table(name = "employee")    // OK
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // better for MySQL
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private Integer age;

    private LocalDate dateOfJoining;

    private Boolean isActive;
}
