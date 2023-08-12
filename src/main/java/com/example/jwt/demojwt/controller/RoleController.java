package com.example.jwt.demojwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.jwt.demojwt.entites.Role;
import com.example.jwt.demojwt.service.RoleService;

@RestController
public class RoleController 
{
	@Autowired
	private RoleService roleService;
	
	@GetMapping({"/createNewRole"})
	public String role()
	{
		return "hi";
	}
	
	@PostMapping({"/createNewRole"})
	public Role createNewRole(@RequestBody Role role)
	{
		return roleService.createNewRole(role);
	}
}
