package com.demo.week1Homework.services;

import com.demo.week1Homework.dto.EmployeeDTO;
import com.demo.week1Homework.entities.EmployeeEntity;
import com.demo.week1Homework.exceptions.ResourseNotFoundException;
import com.demo.week1Homework.repositoris.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;


    public EmployeeServices(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(long id) {
        return employeeRepository.findById(id)
                .map(entity -> modelMapper.map(entity, EmployeeDTO.class));
    }


    public  List<EmployeeDTO> getAllEmployees() {
    List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
 return   employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).collect(Collectors.toList());
}

public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity employeeEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
}

public EmployeeDTO updateEmployeeById(Long employeeId,EmployeeDTO inputEmployee) {
        isExistingEmployeeId(employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity updatedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
}
public  boolean isExistingEmployeeId(Long employeeId) {
    boolean exists = employeeRepository.existsById(employeeId);
    if (!exists) throw new ResourseNotFoundException("Employee not found" + employeeId);
return true;
    }

public boolean deleteEmployeeById(Long employeeId) {
boolean exists = employeeRepository.existsById(employeeId);
if (!exists) {
    return false;
}
            employeeRepository.deleteById(employeeId);
return true;
    }

    public EmployeeDTO patchEmployeeById(Long employeeId, Map<String, Object> updates) {

        // Check if employee exists
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Apply updates using reflection
        updates.forEach((key, value) -> {
            try {
                Field field = EmployeeEntity.class.getDeclaredField(key); // get the field
                field.setAccessible(true); // make it accessible
                field.set(employeeEntity, value); // set new value
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace(); // log if field not found or inaccessible
            }
        });

        // Save updated entity
        EmployeeEntity updatedEmployee = employeeRepository.save(employeeEntity);

        // Convert to DTO and return
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
    }

}
