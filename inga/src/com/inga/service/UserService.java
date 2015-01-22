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
	 * ��ѯ�û���Ϣ
	 * @param id �û�id
	 * @param name �û�name
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
	 * ��ѯ�����û���Ϣ
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
	 * �����û���Ϣ
	 * @param map �û���Ϣ��ɵ�map
	 * 
	 * @return b �����Ƿ���ȫ������Ϣ
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
