package com.training.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.training.services.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	private Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		log.info("Authentication");
		
		auth
		.userDetailsService(myUserDetailsService)
		.passwordEncoder(getPasswordEncoder());
	
		
	}
		
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		log.info("In Password Encoder..");
		PasswordEncoder encoder = new PasswordEncoder()
				{
					@Override
					public String encode(CharSequence rawPassword) {
						
						log.info("In Password Encoder Encode..");
						return rawPassword.toString();
					}

					@Override
					public boolean matches(CharSequence rawPassword, String encodedPassword) {
						log.info("In Password Encoder Matches..");
						return rawPassword.equals(encodedPassword);
					}
			
				};
		
		return encoder;
	}

	//Authorization
	public void configure(HttpSecurity http) throws Exception
	{
		log.info("In Authorization....");
		
		http
		.authorizeRequests()
		.antMatchers("/user/**")
		//.hasRole("USER")
		.hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.and().formLogin();
		
	}
	
}
