package com.example.jwt.demojwt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.demojwt.dao.RoleDAO;
import com.example.jwt.demojwt.dao.UserDAO;
import com.example.jwt.demojwt.entites.Role;
import com.example.jwt.demojwt.entites.User;

@Service
public class UserService 
{
	@Autowired
	private UserDAO userDao;
	

	@Autowired
	private RoleDAO roleDao;
	
	public User registerNewUser(User user)
	{
		return userDao.save(user);
	}
	
	public void initRolesAndUser()
	{
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleDao.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("user role");
		roleDao.save(userRole);
		
		
		User adminuser = new User();
		adminuser.setUserName("admin123");
		adminuser.setUserFirstName("admin");
		adminuser.setUserLastName("admin");
		adminuser.setUserPassword("admin@pass");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminuser.setRole(adminRoles);
		userDao.save(adminuser);

		User user = new User();
		user.setUserName("raj123");
		user.setUserFirstName("raj");
		user.setUserLastName("sharma");
		user.setUserPassword("raj@pass");
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userDao.save(user);
	}
}
