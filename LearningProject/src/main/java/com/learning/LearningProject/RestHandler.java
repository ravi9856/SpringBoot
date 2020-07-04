package com.learning.LearningProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class RestHandler {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/getResponseService1/")
	public ResponseEntity<?> getResponse() {
		
		System.out.println("Received GET Request 1");
		
//		RestTemplate restTemplate = new RestTemplate(); //Not required as called from Bean
		
//		WebClient.Builder webClientBuilder = WebClient.builder(); //Not required as called from Bean
		
//		Using rest Template from Bean
		Employee emp = restTemplate.getForObject("http://localhost:8082/getResponseService2/", Employee.class);
		
		Employee emp2 = webClientBuilder.build()
						.get()
						.uri("http://localhost:8082/getResponseService2/")
						.retrieve()
						.bodyToMono(Employee.class)
						.block();
		
		
		return ResponseEntity.status(HttpStatus.OK)
				.header("Param 1", "Value 2")
				.body("Hello from Microservice 1: Response from 2 : " +
				emp2);
	}

}
