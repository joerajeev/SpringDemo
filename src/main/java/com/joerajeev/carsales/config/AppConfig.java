package com.joerajeev.carsales.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Annotation based spring context configuration
 * 
 * @author Rajeev
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.joerajeev.carsales.dao", "com.joerajeev.carsales.service"})
public class AppConfig {

	Logger log = Logger.getLogger(AppConfig.class);
	
	@Bean
	public DataSource getDataSource() {
		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();
		try {
			dataSource = (DataSource) jndi.lookup("java:comp/env/jdbc/carsalesdb");
		} catch (NamingException e) {
			log.error("Error fetching dataSource");
		}
		return dataSource;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new StandardPasswordEncoder();
	}
}
