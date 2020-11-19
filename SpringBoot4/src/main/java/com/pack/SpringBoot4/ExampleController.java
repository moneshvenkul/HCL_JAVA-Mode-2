package com.pack.SpringBoot4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

@RestController
public class ExampleController {

	@Autowired
	HelloInterface hello;

	@Value("${myProperty}")
	String message;

	@RequestMapping("/")
	public String hello(Model model) {

		String greeting = message + " from " + hello.getGreeting();
		model.addAttribute("greeting", greeting);
		return greeting;

	}
}