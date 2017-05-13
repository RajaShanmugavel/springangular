package com.abc.springmvc.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext arg0) throws ServletException {
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MyAppConfiguration.class);
		ctx.setServletContext(arg0);
		
		ContextLoaderListener loaderListener = new ContextLoaderListener(ctx); // This is required for Spring Security
		arg0.addListener(loaderListener);
		
		ServletRegistration.Dynamic servlet = arg0.addServlet("dispatcher", new DispatcherServlet(ctx));
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

	}

}

