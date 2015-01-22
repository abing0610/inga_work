package com.inga.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.db2.jcc.am.ne;
import com.inga.common.ChangeJsonComm;
import com.inga.common.DateCommon;
import com.inga.common.ServiceAction;
import com.inga.entity.Tree;
import com.inga.service.TreeJsonService;
import com.opensymphony.xwork2.ActionSupport;

public class TreeJsonAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(TreeJsonAction.class);
	private static final long serialVersionUID = -4957463227925819285L;
	private String result;
	
	private HttpServletRequest request;
	
	/*
	 * 获取左边菜单栏的信息
	 * 
	 * @return json
	 * 
	 * @author InGa
	 */
	public String getTreeJson(){
		try {
			TreeJsonService treeJsonService = (TreeJsonService) ServiceAction.userService("treeJsonService");
			
			List<Tree> list = new ArrayList<Tree>();
			list = treeJsonService.getTreeJson();
			
			System.out.println( " list size : " + list.size() );
			
//			String test = "[{ id:1, pId:0, name:\"主菜单 1\"},"
//					+	"{ id:11, pId:1, name:\"子菜单 1-1\"}," +
//					"{ id:111, pId:11, name:\"查询页面\",path:\"./main/index.jsp\"},"+
//					"{ id:112, pId:11, name:\"Tree页面\",path:\"./main/tree.jsp\"}]";
			
			result = ChangeJsonComm.changeListTreeToStr(list);
			
//			System.out.println(test);
//			System.out.println(result);
			logger.info(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
		
		return "succ";
	}
	
	/*
	 * 插入信息节点信息
	 */
	public String insertTreeNode(){
		try {
			
			TreeJsonService treeJsonService = (TreeJsonService) ServiceAction.userService("treeJsonService");
			
			String id= request.getParameter("id");
			String pId= request.getParameter("pId");
			String name= request.getParameter("name");
			String acturl = request.getParameter("acturl");
			
			Tree tree = new Tree();
			tree.setId(id);
			tree.setPid(pId);
			tree.setName(name);
			tree.setActurl(acturl);
			tree.setLev("1");
			tree.setOp("0");
			tree.setUptime(DateCommon.getNowDateDB());
			
			//进行数据库的操作
			treeJsonService.insertTreeNode(tree);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "succ";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
	
	
}
