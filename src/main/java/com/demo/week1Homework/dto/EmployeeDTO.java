package com.demo.week1Homework.dto;

import java.time.LocalDate;

public class EmployeeDTO {


private Long id;
    private String Name;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Integer Age;
    private LocalDate DateofJoining;
    private Boolean IsActive;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public LocalDate getDateofJoining() {
        return DateofJoining;
    }

    public void setDateofJoining(LocalDate dateofJoining) {
        DateofJoining = dateofJoining;
    }

    public Boolean getActive() {
        return IsActive;
    }
    public void setActive(Boolean active) {
        IsActive = active;
    }
    public EmployeeDTO(long employeeid, String name, String email, Integer age, LocalDate dateofJoining, Boolean isActive) {
       id = employeeid;
        Name = name;
        this.email = email;
        Age = age;
        DateofJoining = dateofJoining;
        IsActive = isActive;
    }


}
