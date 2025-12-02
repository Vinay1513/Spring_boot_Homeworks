package com.demo.week1Homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {


private Long id;
    private String Name;
    private String email;



    private Integer Age;
    private LocalDate DateofJoining;
    @JsonProperty("isActive")
    private Boolean IsActive;


    public EmployeeDTO(long employeeid, String name, String email, Integer age, LocalDate dateofJoining, Boolean isActive) {
       id = employeeid;
        Name = name;
        this.email = email;
        Age = age;
        DateofJoining = dateofJoining;
        IsActive = isActive;
    }


}
