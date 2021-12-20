package com.spring.spring.services;

import java.util.List;

import com.spring.spring.entity.User;


public interface UserService {

	public List<User> getUsers();
	
	public User getUser(int userId);
	
	public  User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(Integer parseInt);

	public List<User> SortByDoj();
}
