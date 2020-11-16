package com.hcl.controller;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
protected String[] getServletMappings () {

return new String[] {"/"};
}

@Override
protected Class<?>[] getRootConfigClasses() {
	return null;
}

@Override
protected Class<?>[] getServletConfigClasses() {
	return new Class[]{ LoginApplicationConfig.class};
}
}