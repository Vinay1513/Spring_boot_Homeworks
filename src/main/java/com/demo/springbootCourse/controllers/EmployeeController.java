package com.demo.week1Homework.controllers;

import com.demo.week1Homework.dto.EmployeeDTO;
import com.demo.week1Homework.exceptions.ResourseNotFoundException;
import com.demo.week1Homework.services.EmployeeServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/employee")   // ✔ Added this so POST /employee & GET /employee works
public class EmployeeController {

    private final EmployeeServices employeeService;  // ✔ final + initialized in constructor

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeService = employeeServices;   // ✔ solved "might not have been initialized"
    }

// @GetMapping(path = "/getSecretMessege")
//    public String getSuperSecreatMessage() {
//        return "Secret message: @44gas432";
//    }

//@GetMapping("/employee/{employeeid}")
//    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeid") long id){
//    return new EmployeeDTO(id,"Vinay","demo@gmail.com",22, LocalDate.of(2025,1,13),true );
//}

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long employeeId) {
        Optional<EmployeeDTO>employeeDTO = employeeService.getEmployeeById(employeeId);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).orElseThrow(() -> new ResourseNotFoundException("Employee Not found with this ID" +employeeId));


    }



    @GetMapping
    public List<EmployeeDTO> getAllEmployees(
            @RequestParam(required = false, name ="inputAge") Integer age,
            @RequestParam(required = false) String sortBy   // ✔ removed extra ')'
    ) {
        return employeeService.getAllEmployees();   // ✔ left EXACT as you wrote
    }

//    @GetMapping(path = "/employee")
//    public String getAllEmployees(@RequestParam(required = false) Integer age , @RequestParam(required = false) String sortBy) {
//        return "Hii age " + age + " " + sortBy;
//    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping("/{employeeId}")
    public EmployeeDTO updateEmployeeById(
            @RequestBody EmployeeDTO inputEmployee,
            @PathVariable Long employeeId) {
        return employeeService.updateEmployeeById(employeeId, inputEmployee);
    }




    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId) {
      return   employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDTO patchEmployeeById(
            @RequestBody Map<String, Object> updates,  // ✔ Map to receive partial updates
            @PathVariable Long employeeId
    ) {
        return employeeService.patchEmployeeById(employeeId, updates);
    }


}
