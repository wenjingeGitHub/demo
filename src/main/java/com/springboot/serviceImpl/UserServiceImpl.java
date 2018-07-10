package com.springboot.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import com.springboot.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		list = userMapper.findAllUsers();
		return list;
	}

	@Override
	public List<User> findUserByID(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		list = userMapper.findUserByID(params);
		return list;
	}

	@Override
	public List<User> findUsersByIDs(String[] ids) {
		// TODO Auto-generated method stub
		
		
		
		List<User> list = new ArrayList<User>();
		list = userMapper.findUsersByIDs(ids);
		return list;
	}

}
