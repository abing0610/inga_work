package com.inga.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.db2.jcc.am.id;
import com.inga.common.DateCommon;
import com.inga.common.ServiceAction;
import com.inga.entity.User;
import com.inga.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author abing
 * 查询数据并迁移的action
 *
 */
public class QueryAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(QueryAction.class);
	
	private HttpServletRequest request;
	private List<User> userList = new ArrayList<User>();
	private String result;
	private String ids;
	private String ck;
	/**
	 * 查询用户信息
	 * 
	 * @return success
	 */
	public String queryUser() {
		try {
			
			//查询出文件的路径和文件名字        用###分割
			UserService userService = (UserService) ServiceAction.userService("userService");
			
			userList = userService.queryAllUser();
			
			logger.debug(" userList size : "  + userList.size() );
			
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("---------queryUser action  error-----------------");
		}
		return "success";
	}
	
	/*
	 * 添加用户信息
	 * 
	 * 
	 */
	public String addUser(){
		try {
			
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String province = request.getParameter("province");
			String usertype = request.getParameter("usertype");
			String cardid = request.getParameter("cardid");
			String work = request.getParameter("work");
			
			Map map = new HashMap();
			map.put("id", id);
			map.put("name", name);
			map.put("province", province);
			map.put("usertype", usertype);
			map.put("cardid", cardid);
			map.put("work", work);
			map.put("uptime", DateCommon.getNowDateDB());
			map.put("remark", "");
			
			UserService userService = (UserService) ServiceAction.userService("userService");
			
			boolean b = userService.addUser(map);
			
			logger.info("--------------  :  " + b);
			
			result = b + "";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "succ";
	}
	
	public String deleteUser(){
		try {
			UserService userService = (UserService) ServiceAction.userService("userService");
//			Map session = ActionContext.getContext().getSession();
			System.out.println("ck : " + ck);
			List list = new ArrayList();
			if(ck.indexOf(",") == -1){
				list.add(ck);
			}else {
				String[] str = ck.split(",");
				for (int i = 0; i < str.length; i++) {
					list.add(str[i]);
				}
			}
			boolean b=false;
			for (int i = 0; i < list.size(); i++) {
				b = userService.deleteUser(list.get(i).toString().trim());
				logger.info("delete   :  " + list.get(i).toString() + "  :  user is success");
			}
			
			userList = userService.queryAllUser();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "succ";
	}
	
	public String test(){
		
		return "succ";
	}


	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getCk() {
		return ck;
	}

	public void setCk(String ck) {
		this.ck = ck;
	}

}