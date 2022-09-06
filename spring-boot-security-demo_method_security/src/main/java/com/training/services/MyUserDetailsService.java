package com.training.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.model.MyUser;
import com.training.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	private Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("UserName Entered:"+username);
		
		Optional<MyUser> opUser = userRepo.findById(username);
		
			if(opUser.isPresent())
			{
				MyUser userFound = opUser.get();

				log.info(""+userFound);    // ROLE_USER,ROLE_ADMIN
				/*
				 * List<SimpleGrantedAuthority> list = new ArrayList<>(); String roles[] =
				 * userFound.getRole().split(",");
				 * 
				 * for(String role:roles) { list.add(new SimpleGrantedAuthority(role)); }
				 */
				
				List<SimpleGrantedAuthority> list =Arrays.stream(userFound.getRole().split(","))
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());
				
				return new User(username, userFound.getPassword(), list);
			}
			else
				return null;
	
		
	}


}
