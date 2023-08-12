package com.example.jwt.demojwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.jwt.demojwt.Util.JwtUtil;
import com.example.jwt.demojwt.dao.UserDAO;
import com.example.jwt.demojwt.entites.JwtRequest;
import com.example.jwt.demojwt.entites.JwtResponse;

public class JwtService implements UserDetailsService 
{
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest)
	{
		String username = jwtRequest.getUserName();
		String password = jwtRequest.getUserPassword();
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		return null;
	}
}
