package com.inga.dao;

import java.util.List;
import java.util.Map;

import com.inga.entity.User;

public interface UserDAO {
	
	public List<User> queryUser(String id,String name);
	
	public List<User> queryAllUser();

	public boolean addUser(Map map);
	
	public boolean deleteUser(String id);
	
}
