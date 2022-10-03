package com.logintoken.jwttoken.Controller;

import javax.validation.Valid;

import com.logintoken.jwttoken.Entity.User;
import com.logintoken.jwttoken.ExceptionHandler.ApiException;
import com.logintoken.jwttoken.JwtSecurity.JwtAuthRequest;
import com.logintoken.jwttoken.JwtSecurity.JwtAuthResponse;
import com.logintoken.jwttoken.JwtSecurity.JwtTokenHelper;
import com.logintoken.jwttoken.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;


	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {

		// this.authenticate(request.getUsername(), request.getPassword());
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				request.getUsername(), request.getPassword());
		try {
			this.authenticationManager.authenticate(authenticationToken);
		} catch (BadCredentialsException e) {
			throw new ApiException("Invalid Username OR Password!!!");
		}
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		response.setUser((User)userDetails);
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	
	@PostMapping("/register")	
	public ResponseEntity<User> registerNewUser(@Valid @RequestBody User userDto){
		User registerNewUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<User>(registerNewUser,HttpStatus.CREATED);
	}

}
