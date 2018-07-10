package com.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pojo.User;
import com.springboot.service.IUserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/userController")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	@RequestMapping("/sayHello")
	@ResponseBody
	public String sayHello(){
		return "Hello World!";
	}
	
	@RequestMapping("/sayHello1")
	@ResponseBody
	public String sayHello1(){
		return "Hello World!";
	}

	@RequestMapping("/sayHello2")
	@ResponseBody
	public String sayHello2(){
		return "Hello World!";
	}
	
	@RequestMapping("/two")
	public String hello(){
		return "world";
		
	}
	
	@RequestMapping("/getUser")
	public User getUser(){
		User user = new User(1, "云天河", "123456", "男", "18");
		return user;
	}
	
	@RequestMapping("/getMap")//返回jsonObject
	public Map<String,Object> getMap(){
		Map<String,Object> map = new HashMap<String, Object>();
		User user = new User(1, "云天河", "123456", "男", "18");
		map.put("role", user);
		return map;
	}
	
	@RequestMapping("/getList")//返回jsonArray
	public List<User> getList(){
		List<User> list = new ArrayList<User>();
		User user1 = new User(1, "云天河", "123456", "男", "18");
		User user2 = new User(2, "韩菱纱", "123456", "女", "17");
		User user3 = new User(2, "慕容紫英", "123456", "男", "19");
		User user4 = new User(2, "柳梦璃", "123456", "女", "20");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		return list;
	}
	
	/**
	 * 整合mybatis
	 */
	@RequestMapping("/findAllUsers")
	@ResponseBody	
	public List<User> findAllUsers(){
		List<User> list = new ArrayList<User>();
		list = userService.findAllUsers();
		return list;
	}
	
	/**
	 * 动态参数是map
	 * @return
	 */
	@RequestMapping("/findUserByID")
	@ResponseBody
	public List<User> findUserByID(HttpServletRequest request,Model model){
		List<User> list = new ArrayList<User>();
		Map<String,Object> params = new HashMap<String,Object>();
		String ids = request.getParameter("ids");
		System.out.println("id:"+ids);
//		String ids = "1,2,3";
		String[] idArr = ids.split(",");
		
		params.put("userName", "李四");
		params.put("idArr", idArr);
		list = userService.findUserByID(params);
		return list;
	}
	
	/**
	 * 动态参数是array
	 * @return
	 */
	@RequestMapping("/findUsersByIDs")
	@ResponseBody
	public List<User> findUsersByIDs(){
		List<User> list = new ArrayList<User>();
		String[] ids = {"1","2"};
		list = userService.findUsersByIDs(ids);
		return list;
	}
}
