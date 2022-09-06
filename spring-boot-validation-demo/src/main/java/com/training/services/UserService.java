package com.training.services;

import org.springframework.stereotype.Service;

import com.training.dto.UserDto;
import com.training.model.User;
import com.training.util.Utils;

@Service
public class UserService {
	
	public void saveUser(UserDto userDto)
	{
		User user = Utils.dtoToEntity(userDto);
		System.out.println(user);
	}

}
