package com.learning.LearningProject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHandler {
	
	@RequestMapping("/getResponse/")
	public ResponseEntity<?> getResponse() {
		
		System.out.println("Received GET Request");
		
		return ResponseEntity.status(HttpStatus.OK)
				.header("Param 1", "Value 1")
				.body("Hello Spring");
	}

}
