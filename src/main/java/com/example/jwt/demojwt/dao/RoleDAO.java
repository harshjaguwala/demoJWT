package com.example.jwt.demojwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.demojwt.entites.Role;

@Repository
public interface RoleDAO extends CrudRepository<Role,String> 
{

}
