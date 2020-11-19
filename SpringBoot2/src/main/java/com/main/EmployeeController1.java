package com.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController1 {
	
	@GetMapping(value="/hello1")
	public String show() {
		return "Hello Spring Boot";
	}

}
