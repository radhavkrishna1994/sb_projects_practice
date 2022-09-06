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

import com.training.config.SecurityConfig;
import com.training.model.MyUser;
import com.training.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

	// username is one that is entered by the user on the form
	//private Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) {

		log.info("In MyUserDetailsService");
		//get the details
		Optional<MyUser> myUserOp = userRepo.findById(username);
		MyUser myUser=null;
		if(myUserOp.isPresent())
		{
			myUser=myUserOp.get();
			log.info("MyUser details:"+myUser); // 'admin2','admin123','ROLE_USER,ROLE_ADMIN')

			String roleString = myUser.getRole();
			// before java 8
			/*	List<SimpleGrantedAuthority> list = new ArrayList<>();
		 //'ROLE_USER,ROLE_ADMIN'

		String roles[] = roleString.split(",");
		for(String role:roles)
		{
			list.add(new SimpleGrantedAuthority(role));
		}
			 */	
			//java 8

			List<SimpleGrantedAuthority> list = Arrays.stream(roleString.split(","))
					.map(SimpleGrantedAuthority::new).collect(Collectors.toList());

			return new User(username, myUser.getPassword(), list);
		}
		else
			throw new UsernameNotFoundException("User not found");
	}

}
