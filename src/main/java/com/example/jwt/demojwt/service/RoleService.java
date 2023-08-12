package com.example.jwt.demojwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.demojwt.dao.RoleDAO;
import com.example.jwt.demojwt.entites.Role;

@Service
public class RoleService 
{
	@Autowired
	private RoleDAO roleDao;
	
	public Role createNewRole(Role role)
	{
		return roleDao.save(role);
	}
}
