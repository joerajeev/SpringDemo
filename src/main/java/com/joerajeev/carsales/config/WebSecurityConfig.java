package com.joerajeev.carsales.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring security configuration
 * 
 * @author Rajeev
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String USERS_BY_USERNAME_QUERY = "select * from (select email as username, password, enabled from users) users where username = ?";

	@Autowired
	DataSource dataSource;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		try {
			auth.jdbcAuthentication()
					.dataSource(dataSource)
					.usersByUsernameQuery(
							USERS_BY_USERNAME_QUERY)
					.passwordEncoder(passwordEncoder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        .antMatchers("/","/static/**", "/buy", "/login", "/logged-out", "/sign-up", "/docreateuser").permitAll()
	        .antMatchers("/sell", "/docreatecar", "/docreatead").hasRole("USER")
	        .antMatchers("/**").hasRole("ADMIN")
	        .anyRequest().authenticated()
	        .and()
	      .formLogin()
	        .loginPage("/login")
	        .failureUrl("/login?error")
	        .permitAll()
	        .and()
	       .logout()
	        .logoutSuccessUrl("/?msg=logged-out")
	        .and()
	       .csrf()		//Disabling CRSF as this is just a Demo
	       	.disable();	//Do not do this in production!
	  }
}
