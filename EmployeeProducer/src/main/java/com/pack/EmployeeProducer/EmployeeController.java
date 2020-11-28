package com.pack.EmployeeProducer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmployeeController {
	@RequestMapping(value="/employee", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee firstPage() {
		Employee emp = new Employee("1","emp1","manager",3000);
		if(emp.getName().equalsIgnoreCase("emp1")) {
			throw new RuntimeException();
		}
		return emp;
	}
	
	public Employee getDataFallBack() {
		Employee emp = new Employee("fallback-1","fallback-emp1","fallback-manager",3000);
		return emp;
	}
}
