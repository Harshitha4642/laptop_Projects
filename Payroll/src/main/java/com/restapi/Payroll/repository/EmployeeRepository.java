package com.restapi.Payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.Payroll.entity.Employee;

interface EmployeeRepository extends JpaRepository<Employee, Long> {

}