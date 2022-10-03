package com.logintoken.jwttoken.JwtSecurity;

import com.logintoken.jwttoken.Entity.User;
import com.logintoken.jwttoken.ExceptionHandler.ApiException;
import com.logintoken.jwttoken.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;





@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ApiException(" Username is Not Found!......") );
		return user;
	}

}
