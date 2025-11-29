package com.demo.week1Homework.repositoris;

import com.demo.week1Homework.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {




}
