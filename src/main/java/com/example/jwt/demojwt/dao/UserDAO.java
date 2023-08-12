package com.example.jwt.demojwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.demojwt.entites.User;

@Repository
public interface UserDAO  extends CrudRepository<User, String>
{

}
