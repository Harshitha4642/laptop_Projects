package com.micro.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.micro.employee.entity.Employee;
import com.micro.employee.feignClient.AddressClient;
import com.micro.employee.repository.EmployeeRepository;
import com.micro.employee.response.AddressResponse;
import com.micro.employee.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired 
	private EmployeeRepository empRepo;
	
//	@Autowired
//	private ModelMapper modelMap;
	
	@Autowired
	private AddressClient addressClient;
	
	public EmployeeResponse getEmployeeByID(int id)
	{
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isEmpty())
		{
			return null;
		}
		else
		{
			Employee employee = emp.get();
			EmployeeResponse empRes = new EmployeeResponse();
			empRes.setId(employee.getId());
			empRes.setName(employee.getName());
			empRes.setEmail(employee.getEmail());
			empRes.setAge(employee.getAge());
			System.out.println("I am ok till here");
			ResponseEntity<AddressResponse> addressRes = addressClient.getAddressByEmployeeID(employee.getId());
			empRes.setAddressResponse(addressRes.getBody());
			
			return empRes;
		}
	}
	
	
	
	

}
