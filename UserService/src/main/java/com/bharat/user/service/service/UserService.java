package com.bharat.user.service.service;

import java.util.List;

import com.bharat.user.service.entities.User;

public interface UserService {

	//to save data
	User SaveUser(User user);
	
	List<User> GetAllUser();
	
	User FindById(String userID);
	
	void DeleteById(String id);
	
	User Update(User user);
	
}
