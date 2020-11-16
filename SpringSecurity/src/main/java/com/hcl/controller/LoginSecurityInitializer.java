package com.hcl.controller;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//https://www.mkyong.com/spring-security/customize-http-403-access-denied-page-in-spring-security/
//https://www.concretepage.com/spring/spring-security/spring-mvc-security-in-memory-authentication-example-with-authenticationmanagerbuilder-using-java-configuration
public class LoginSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

	public LoginSecurityInitializer() {
		super(LoginSecurityConfig.class);
		
	}


	
}
