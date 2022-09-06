package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.training.util.JwtUtil;

@RestController
public class SecurityController {

	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello Security App";
	}

	@GetMapping("/user/hello")
	public String sayHelloUser()
	{
		return "Hello User";
	}

	@GetMapping("/admin/hello")
	public String sayAdminUser()
	{		
		return "Hello Admin";

	}
	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/authenticate") // {"username":"user1","password","user123"}
	public String authenticate(@RequestBody Input input) { 
		try { 
			authManager.authenticate(new
					UsernamePasswordAuthenticationToken(input.getUsername(),input.getPassword()));

			// load the userdetailsservice 
			// validate the user
			// User Object
			return jwtUtil.generateToken(input.getUsername()); } 

		catch(BadCredentialsException ex) {

			return ex.getMessage(); } }



}
