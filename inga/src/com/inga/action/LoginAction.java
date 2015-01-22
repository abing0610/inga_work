package com.inga.action;

import com.inga.common.BaseAction;

public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9004244637279538482L;
	private String id;
	private String password;
	private String ok;

	public String login() {
		try {
			
			this.id = id;
			this.password = password;
			
			System.out.println(id);
			System.out.println(password);
			
			
			if (id.equals("admin") && password.equals("111")) {
				ok="ok";
				System.out.println("ok!!!!!!!!!!!!!!!!!!!!!!");
				
			}else {
				
				System.out.println("fail---------------------");
				ok="fail";
				return "fail";
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
		return "succ";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}
	
	
}
