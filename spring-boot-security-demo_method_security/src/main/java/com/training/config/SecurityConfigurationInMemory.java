package com.training.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class SecurityConfigurationInMemory extends WebSecurityConfigurerAdapter {

	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.inMemoryAuthentication()   //UserDetailsService
		.withUser("user1")
		.password("{noop}user123")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("{noop}admin123")
		.roles("ADMIN");
	}

	// Authorization
	public void configure(HttpSecurity http) throws Exception
	{
			http
			.authorizeRequests()
			.antMatchers("/user/**")
		//	.hasRole("USER")
			.hasAnyRole("USER","ADMIN")
			.antMatchers("/admin")
			.hasRole("ADMIN")
			.and()
			.formLogin();
			
	}
}
