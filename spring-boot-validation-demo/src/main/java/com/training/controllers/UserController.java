package com.training.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.UserDto;
import com.training.services.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public void saveUser(@RequestBody @Valid UserDto userDto)
	{
		userService.saveUser(userDto);
	}
	
	
}
