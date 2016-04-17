package com.joerajeev.carsales.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Configures the servlet context programmatically
 * (i.e replacing the web.xml)
 * 
 * @author Rajeev
 *
 */
public class CarSalesWebApplicationInitalizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		/*
		 * Adding the springSecurityFilterChain filter to the servlet context
		 * Alternatively could have extended the AbstractSecurityWebApplicationInitializer  
		 */
		FilterRegistration.Dynamic filterReg = container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
		filterReg.addMappingForUrlPatterns(null, true, "/*");
		
		/*
		 * Loading application contexts from the Annotation Config classes
		 * Alternatively, we could have extended the AbstractAnnotationConfigDispatcherServletInitializer and overridden 
		 * the getRootConfigClasses() / getServletConfigClasses()
		 */
		AnnotationConfigWebApplicationContext annoAppCtx = new AnnotationConfigWebApplicationContext();
		annoAppCtx.register(AppConfig.class, WebSecurityConfig.class);
		container.addListener(new ContextLoaderListener(annoAppCtx));
				
		//Replaced the below xml based config by the Annotation based config 
		/*XmlWebApplicationContext appCtx = new XmlWebApplicationContext();
		appCtx.setConfigLocation("classpath:com/joerajeev/carsales/config/app-context.xml");
		container.addListener(new ContextLoaderListener(appCtx));
		
		XmlWebApplicationContext dispatcherContext = new XmlWebApplicationContext();
		dispatcherContext.setConfigLocation("/WEB-INF/carsales-servlet.xml");*/
		
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebConfig.class);

		ServletRegistration.Dynamic dispatcher = container.addServlet(
				"dispatcher", new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
