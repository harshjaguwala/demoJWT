package com.example.jwt.demojwt.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.demojwt.entites.User;
import com.example.jwt.demojwt.service.UserService;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initRolesAndUser() 
	{
		userService.initRolesAndUser();
	}
	
	@PostMapping({"/registerNewUser"})
	public User registerNewUser(@RequestBody User user)
	{
		return userService.registerNewUser(user);
	}
	@GetMapping("forAdmin")
	public String forAdmin()
	{
		return "this url for admin";
	}
	
	@GetMapping("forUser")
	public String forUser()
	{
		return "this url for user";
	}
}
