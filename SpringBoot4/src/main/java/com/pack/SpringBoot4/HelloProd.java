package com.pack.SpringBoot4;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class HelloProd implements HelloInterface {

	@Override
	public String getGreeting() {
		return "Hello from Prod";

	}
}