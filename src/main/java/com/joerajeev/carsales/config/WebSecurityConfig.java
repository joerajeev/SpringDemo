package com.joerajeev.carsales.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends
		WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		try {
			//auth.inMemoryAuthentication().withUser("joerajeev@yahoo.co.uk").password("1qaz2wsx@").roles("USER");
			auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select * from (select email as username, password, enabled from users) users where username = ?")
				.passwordEncoder(passwordEncoder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        .antMatchers("/","/static/**", "/buy", "/login", "j_spring_security_logout", "/logged-out", "/sign-up", "/docreateuser").permitAll()
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
	        .logoutUrl("/?msg=logged-out")
	        .and()
	       .csrf()		//Disabling CRSF as this is just a Demo
	       	.disable();	//Do not do this in production!
	  }
}
