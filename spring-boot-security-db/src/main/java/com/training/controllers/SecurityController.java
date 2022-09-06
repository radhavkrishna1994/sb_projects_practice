package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
