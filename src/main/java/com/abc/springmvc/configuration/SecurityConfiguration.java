package com.abc.springmvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("raja").password("abc123").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("abc123").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/").access("hasRole('USER')")
			.and().formLogin()
			.and().exceptionHandling().accessDeniedPage("/Access_Denied");
		
		http.csrf().disable(); // This is IMPORTANT. Required to do operations DELETE, POST, PUT... Without this line, only GET will work from Controller
	}
	

}
