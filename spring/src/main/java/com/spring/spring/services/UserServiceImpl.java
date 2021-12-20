package com.spring.spring.services;

import java.util.Comparator;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.spring.dao.UserDao;
import com.spring.spring.entity.User;



@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserDao userDao;
	
	
	public UserServiceImpl() {
			
	}
	
	@Override
	public List<User> getUsers() {
	  
		return userDao.findAll();
	}

	@Override
	public User getUser(int userId) {
		
		return userDao.getById(userId);
	}

	@Override
	public User addUser(User user) {
	
		userDao.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		
		userDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(Integer parseInt) {
	
		User entity = userDao.getById(parseInt);
		
		 userDao.delete(entity);
	}

	@Override
	public List<User> SortByDoj() {

		List<User> userdb = userDao.findAll();
		
		 List<User> sortedUser = userdb.stream()
		  .sorted(Comparator.comparing(User::getDoj) .thenComparing(User::getDoj)) .collect(Collectors.toList());
		 
		return sortedUser;
		
	}

}
