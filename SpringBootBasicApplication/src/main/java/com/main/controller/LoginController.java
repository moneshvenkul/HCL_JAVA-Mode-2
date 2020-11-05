package com.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.model.Login;

@RestController
public class LoginController {

 

	@GetMapping("/login")
    public ModelAndView loginPage(@ModelAttribute("login") Login login)
    {
        return new ModelAndView("login");
    }
    
    @GetMapping("/register")
    public ModelAndView registerPage()
    {
        return new ModelAndView("register");
    }
    
    @GetMapping("/success")
    public ModelAndView successPage()
    {
        return new ModelAndView("success");
    }
    
    @GetMapping("/welcome")
    public ModelAndView welcomePage()
    {
        return new ModelAndView("welcome");
    }
}