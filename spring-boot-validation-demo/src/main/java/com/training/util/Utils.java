package com.training.util;

import org.springframework.beans.BeanUtils;

import com.training.dto.UserDto;
import com.training.model.User;

public class Utils {


    public static UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public static User dtoToEntity(UserDto userDto) {
    	User user = new User();
        BeanUtils.copyProperties(userDto, user,"email");
		/*
		 * user= User.builder() .username(userDto.getUsername()) .build();
		 */
    		
    	
        return user;
    }
}
