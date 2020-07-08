package com.example.walletshopping.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer>{

	
}
