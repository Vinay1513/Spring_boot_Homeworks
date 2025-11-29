package com.demo.week1Homework.controllers;

import com.demo.week1Homework.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmolyeeController {
// @GetMapping(path = "/getSecretMessege")
//    public String getSuperSecreatMessage() {
//        return "Secret message: @44gas432";
//    }

@GetMapping("/employee/{employeeid}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeid") long id){
    return new EmployeeDTO(id,"Vinay","demo@gmail.com",22, LocalDate.of(2025,1,13),true );
}


    @GetMapping(path = "/employee")
    public String getAllEmployees(@RequestParam(required = false) Integer age , @RequestParam(required = false) String sortBy) {
        return "Hii age " + age + " " + sortBy;
    }



}
