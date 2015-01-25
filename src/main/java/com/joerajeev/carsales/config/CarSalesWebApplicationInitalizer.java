package com.joerajeev.carsales.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class CarSalesWebApplicationInitalizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		XmlWebApplicationContext appCtx = new XmlWebApplicationContext();
		appCtx.setConfigLocation("classpath:com/joerajeev/carsales/config/app-context.xml");
		container.addListener(new ContextLoaderListener(appCtx));
		
		FilterRegistration.Dynamic filterReg = container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
		filterReg.addMappingForUrlPatterns(null, true, "/*");
		
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocation("/WEB-INF/carsales-servlet.xml");

		ServletRegistration.Dynamic dispatcher = container.addServlet(
				"dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
