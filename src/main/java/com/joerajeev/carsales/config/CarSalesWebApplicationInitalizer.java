package com.joerajeev.carsales.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class CarSalesWebApplicationInitalizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		/*
		 * Loading application contexts from the AnnotationConfig classes
		 * Alternatively, could have extended the AbstractAnnotationConfigDispatcherServletInitializer  and overridden 
		 * the getRootConfigClasses()
		 */
		AnnotationConfigWebApplicationContext annoAppCtx = new AnnotationConfigWebApplicationContext();
		annoAppCtx.register(AppConfig.class, WebSecurityConfig.class);
		container.addListener(new ContextLoaderListener(annoAppCtx));
				
		//Replaced the below xml based config by the Annotation based config (above)
		//(Left this here just for reference)
		/*XmlWebApplicationContext appCtx = new XmlWebApplicationContext();
		appCtx.setConfigLocation("classpath:com/joerajeev/carsales/config/app-context.xml");
		container.addListener(new ContextLoaderListener(appCtx));*/
		
		FilterRegistration.Dynamic filterReg = container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
		filterReg.addMappingForUrlPatterns(null, true, "/*");
		
		XmlWebApplicationContext dispatcherContext = new XmlWebApplicationContext();
		dispatcherContext.setConfigLocation("/WEB-INF/carsales-servlet.xml");

		ServletRegistration.Dynamic dispatcher = container.addServlet(
				"dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
