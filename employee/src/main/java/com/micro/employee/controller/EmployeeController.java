package com.micro.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.employee.response.EmployeeResponse;
import com.micro.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees/{id}")
	private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id)
	{
		EmployeeResponse emp = employeeService.getEmployeeByID(id);
		System.out.println(emp.getAge());
		System.out.println(emp.getEmail());
		
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	
	
	
	

}
