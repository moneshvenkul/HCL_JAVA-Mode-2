package com.hcl.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class SpringMVCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	protected Class<?>[] getRootConfigClasses() {
	return null;
	}
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{ LoginApplicationConfig.class };
	}
	protected String[] getServletMappings() {
			return new String[] {"/"};
	}
}