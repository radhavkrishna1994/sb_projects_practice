package com.training.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.exceptions.CredentialsException;
import com.training.model.AuthRequest;
import com.training.model.MyUser;
import com.training.services.TestService;
import com.training.util.JwtUtil;

@RestController
public class SecurityController {

	/*
	 * @GetMapping public String sayHello() { return
	 * "Hello ! Welcome to Spring Security"; }
	 */

	@GetMapping("/user/hello")
	public String sayHelloUser() {
		return "Hello User ! Welcome to Spring Security";
	}

	@GetMapping("/user/hello1")
	public String sayHello1User() {
		return "Hello User again ! Welcome to Spring Security";
	}

	@GetMapping("/admin")
	public String sayHelloAdmin() {
		return "Hello Admin ! Welcome to Spring Security";
	}

	/*
	 * @Autowired private AuthenticationManager authManager;
	 */

	@Autowired
	private JwtUtil jwtUtil;

	Logger log = LoggerFactory.getLogger(SecurityController.class);

	/*
	 * @PostMapping("/authenticate") public String authenticate(@RequestBody
	 * AuthRequest authRequest) throws Exception {
	 * log.info("Inside Authenticate method");
	 * 
	 * //try { authManager.authenticate( new
	 * UsernamePasswordAuthenticationToken(authRequest.getUsername(),
	 * authRequest.getPassword()) ); }catch(Exception ex) {
	 * log.info("Exception :"+ex); //throw new
	 * CredentialsException("BadCredentials",HttpStatus.BAD_REQUEST); return
	 * "Bad Credentials"; } return jwtUtil.generateToken(authRequest.getUsername());
	 * 
	 * }
	 */

	@Autowired
	private TestService testService;
	// serviceAll

	@GetMapping("/all")
	public String testAll() {
		//code
		return testService.getServiceAll();
	}
	
	
	@GetMapping("/service1")
	public MyUser testService() {
		//code
		return testService.getService1();
	}

}
