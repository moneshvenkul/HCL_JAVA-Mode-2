package com.pack.SpringBoot2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@GetMapping(value="/hello")
	public String add() {
		return "Hello Spring Boot app";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public List<Employee> getEmployees(){
		List<Employee> l =new ArrayList<>();
		l.add(new Employee(1,"monesh","male",90000));
		l.add(new Employee(2,"venkul","male",80000));
		return l;
		
	}
}
