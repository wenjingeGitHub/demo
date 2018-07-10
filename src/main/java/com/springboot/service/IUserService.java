package com.springboot.service;

import java.util.List;
import java.util.Map;

import com.springboot.pojo.User;

public interface IUserService {

	List<User> findAllUsers();

	List<User> findUserByID(Map<String, Object> params);

	List<User> findUsersByIDs(String[] ids);
	
	
	

}
