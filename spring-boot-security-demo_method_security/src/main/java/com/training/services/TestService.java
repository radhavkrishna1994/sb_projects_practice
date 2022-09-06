package com.training.services;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.training.model.MyUser;

@Service
public class TestService {


	
	  @PreAuthorize(value = "hasRole('ROLE_USER')")
	  @PostAuthorize("returnObject.username == principal.username") //spEL user1
	  public MyUser getService1() { 
		  System.out.println("Method Executing......");
	  return new MyUser("user1", "user123","ROLE_USER"); 
	  }
	 

	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public String getServiceAll()
	{
		return "hello service all";
	}

}

