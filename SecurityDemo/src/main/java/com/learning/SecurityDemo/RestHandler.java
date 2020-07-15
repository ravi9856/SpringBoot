package com.learning.SecurityDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHandler {
	
	@RequestMapping("/general")
	public String getGeneral() {
		
		return "<h1>HELLO ALL!!</h1>";
	}
	
	@RequestMapping("/user")
	public String getUser() {
		
		return "<h1>HELLO User!!</h1>";
	}
	
	@RequestMapping("/admin")
	public String getAdmin() {
		
		return "<h1>HELLO Admin!!</h1>";
	}

}
