package com.demo.week1Homework.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {

    @Override
    public boolean isValid(String inputRoles , ConstraintValidatorContext constraintValidatorContext) {
     List<String> roles = List.of("USER", "ADMIN");
     return roles.contains(inputRoles);
    }
}
