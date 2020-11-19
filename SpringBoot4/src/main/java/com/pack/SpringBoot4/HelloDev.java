package com.pack.SpringBoot4;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class HelloDev implements HelloInterface {

	public String getGreeting() {
		return "Hello from Dev";
	}
}