package com.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.pojo.User;

@Mapper
public interface UserMapper {

	List<User> findAllUsers();

	List<User> findUserByID(Map<String, Object> params);

	List<User> findUsersByIDs(String[] ids);

}
