package com.spring.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.entity.User;



public interface UserDao extends JpaRepository<User, Integer> {
   
	
}
