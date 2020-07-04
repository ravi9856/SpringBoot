package com.learning.Microservice2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestHandler {
	
	@RequestMapping("/getResponseService2/")
	public Employee getResponse() {
		
		System.out.println("Received GET Request 2");
		
		return new Employee(123, 5000, "Ravi");
	}

}
