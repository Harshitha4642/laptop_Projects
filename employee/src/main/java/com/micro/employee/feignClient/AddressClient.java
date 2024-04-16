package com.micro.employee.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.employee.response.AddressResponse;

@FeignClient(name = "address-service", url = "http://localhost:8081", path = "/address-service")
public interface AddressClient {
	@GetMapping("/api/address/{id}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeID(@PathVariable("id") int id);

}
