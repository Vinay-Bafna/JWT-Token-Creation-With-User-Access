package com.logintoken.jwttoken.JwtSecurity;
import com.logintoken.jwttoken.Entity.User;



public class JwtAuthResponse {

	private String token;
	private User user;

	public JwtAuthResponse() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JwtAuthResponse(String token, User user) {
		this.token = token;
		this.user = user;
	}
}
