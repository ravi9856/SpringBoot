package com.learning.LearningProject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestHandler {
	
	@RequestMapping("/getResponse/")
	public ResponseEntity<?> getResponse() {
		
		System.out.println("Received GET Request");
		
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject("http://localhost:8082/anotherService", Employee.class);
		
		return ResponseEntity.status(HttpStatus.OK)
				.header("Param 1", "Value 1")
				.body("Hello Spring");
	}

}
