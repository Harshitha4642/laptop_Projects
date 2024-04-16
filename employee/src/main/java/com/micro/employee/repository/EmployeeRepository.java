package com.micro.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.micro.employee.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
