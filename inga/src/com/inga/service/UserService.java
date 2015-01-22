package com.inga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inga.dao.UserDAO;
import com.inga.entity.User;

@Service("userService")
public class UserService {

	private UserDAO userDAO; 
	
	/*
	 * 查询用户信息
	 * @param id 用户id
	 * @param name 用户name
	 * 
	 * @return inga List<User>
	 * 
	 */
	public List<User> queryUser(String id,String name){
		
		List<User> inga = new ArrayList<User>();
		inga = this.userDAO.queryUser(id, name);
		return inga;
		
	}
	
	/*
	 * 查询所有用户信息
	 * 
	 * @return inga List<User>
	 * 
	 */
	public List<User> queryAllUser(){
		
		List<User> inga = new ArrayList<User>();
		inga = this.userDAO.queryAllUser();
		return inga;
		
	}
	
	/*
	 * 增加用户信息
	 * @param map 用户信息组成的map
	 * 
	 * @return b 返回是否是全部的信息
	 * 
	 */
	public boolean addUser(Map map){
		boolean b = false;
		try {
			
			b = this.userDAO.addUser(map);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean deleteUser(String id){
		boolean b = false;
		try {
			b=this.userDAO.deleteUser(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
