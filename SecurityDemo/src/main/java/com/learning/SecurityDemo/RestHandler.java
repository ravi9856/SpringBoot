package com.learning.SecurityDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHandler {
	
	@RequestMapping("/checkSecurity/")
	public String getResponse() {
		
		return "HELLO from Security App!!";
	}

}
