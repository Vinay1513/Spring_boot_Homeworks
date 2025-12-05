package com.demo.week1Homework.dto;

import com.demo.week1Homework.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {


    private Long id;
    @NotEmpty(message = "Name should not be empty")
    private String Name;
    private String email;


    @Max(value = 80,message = "Age of the Employee cannot be greater than 80")
    @Min(value = 18 ,message = "Age of the Employee cannot be less than 18")
    private Integer Age;
    @PastOrPresent
    private LocalDate DateofJoining;

    @NotNull(message = "Salary of the Employee should be not null")
    @Positive(message = "Salary of the Employee should be Positive")
   @Digits(integer = 6 , fraction =  2)
    private  Integer Salary;
    @JsonProperty("isActive")
    private Boolean IsActive;

  //  @NotBlank(message = "Role of the Employee should not be null")
    // @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of the Employee either Admin or User")
    @EmployeeRoleValidation
    private String role;


    public EmployeeDTO(long employeeid, String name, String email, Integer age, LocalDate dateofJoining, Boolean isActive) {
       id = employeeid;
        Name = name;
        this.email = email;
        Age = age;
        DateofJoining = dateofJoining;
        IsActive = isActive;
    }


}
