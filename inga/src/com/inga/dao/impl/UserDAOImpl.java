package com.inga.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Component;

import com.inga.dao.SuperDAO;
import com.inga.dao.UserDAO;
import com.inga.entity.User;

@Component("userDAO")
public class UserDAOImpl extends SuperDAO implements UserDAO {
	

	public List<User> queryUser(String id, String name) {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		try {
			
			Map map = new HashMap(); 
			map.put("id", id);
			map.put("name", name);
			
			list = this.getSqlSession().selectList(User.class.getName() + ".selectUserById",map);
			
			System.out.println("  size :   " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		try {
			
			list = this.getSqlSession().selectList(User.class.getName() + ".selectAllUser");
			
			System.out.println("  size :   " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * 
	 * 
	 */
	public boolean addUser(Map map) {
		boolean b = false;
		try {
			int i =0;
			
			i = this.getSqlSession().insert(User.class.getName() + ".addUser",map);
			
			System.out.println("----------------            "+i+"           -------------");
			
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		boolean b=false;
		try {
			int i =0;
			
			i = this.getSqlSession().insert(User.class.getName() + ".deleteUser",id);
			
			System.out.println("----------------            "+i+"           -------------");
			
			if (i>0) {
				b = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return b;
	}

	
}
