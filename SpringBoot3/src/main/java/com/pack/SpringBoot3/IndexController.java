package com.pack.SpringBoot3;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

@RequestMapping("/")
public String home(Map<String, Object> model)
{
	model.put("message", "Welcome to Spring Boot");
	return "index";
}



@RequestMapping("/next")
public String next(Map<String, Object> model)
{
	model.put("message", "Spring Boot JSP View");
	return"next";

}

	

}
