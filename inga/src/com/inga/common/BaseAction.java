package com.inga.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private ServletContext servletContext;
	
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext = servletContext;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
	
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public ServletContext getServletContext() {
		return servletContext;
	}
	
	
	
	
	
	/*private String test;
	private String test1;
	private String test2;
	
	public String te() {
		
		this.test = "test";
		this.test1 = "test1";
		this.test2 = "test2";
		
		return "succ";
	}
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getTest1() {
		return test1;
	}
	public void setTest1(String test1) {
		this.test1 = test1;
	}
	public String getTest2() {
		return test2;
	}
	public void setTest2(String test2) {
		this.test2 = test2;
	}*/
	
	
	
////	private static final long serialVersionUID = -676538067021681709L;  
//	   private String lookup;  
//	   private String workflow;  
//	//   private Object errorObject;  
//	   protected static final String DOWNLOAD = "download";  
//	   protected static final String AUTO = "auto";  
//	   private ActionProxy proxy;  
//	   private int statusCode = 200;  
//	   private String tipsMessage;  
//	   private String forwardUrl;  
//	   private String ajax;  
//	   
//	   public ActionProxy getProxy()  
//	   {  
//	     if (this.proxy == null)  
//	       this.proxy = ActionContext.getContext().getActionInvocation().getProxy();  
//	     return this.proxy;  
//	   }  
//	   
//	   public String getLookup() {  
//	     return this.lookup;  
//	   }  
//	   
//	   public void setLookup(String lookup) {  
//	     this.lookup = lookup;  
//	   }  
//	   
//	   public HttpServletRequest getRequest() {  
//	     return ServletActionContext.getRequest();  
//	   }  
//	   
//	   public HttpServletResponse getResponse() {  
//	     return ServletActionContext.getResponse();  
//	   }  
//	   
//	   public HttpSession getSession()  
//	   {  
//	     return ServletActionContext.getRequest().getSession(true);  
//	   }  
//	   
//	   public String getParameter(String name) {  
//	     return getRequest().getParameter(name);  
//	   }  
//	   
//	//   public Object getErrorObject() {  
////	     return this.errorObject;  
//	//   }  
//	//   
//	//   public void setErrorObject(Object errorObject) {  
////	     this.errorObject = errorObject;  
//	//   }  
//	   
//	   protected Date getDateFromStr(String sendTime_str)  
//	   {  
//	     Date returnDate = null;  
//	     DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
//	     if ((sendTime_str == null) || (sendTime_str.equals("")))  
//	     {  
//	       return null;  
//	     }  
//	     try  
//	     {  
//	       returnDate = df.parse(sendTime_str);  
//	     }  
//	     catch (Exception e)  
//	     {  
//	       returnDate = null;  
//	     }  
//	   
//	     return returnDate;  
//	   }  
//	   
//	    
//	   public String getWorkflow() {  
//	     return this.workflow;  
//	   }  
//	   
//	   public void setWorkflow(String workflow) {  
//	     this.workflow = workflow;  
//	   }  
//	   
//	   protected String returnCommand(){  
//	     return returnCommand(null);   
//	   }  
//	   
//	   protected String returnCommand(String message) {  
//	       if ((((this.ajax == null) || (!(this.ajax.trim().equals("1"))))) && (message == null))  
//	         return "success";  
//	       if (message == null) {  
//	           //ajaxForwardSuccess(I18NUtil.getString("鎿嶄綔鎴愬姛"))  
//	         return ajaxForwardSuccess("成功!");  
//	       }  
//	       return ajaxForwardError(message);  
//	   }  
//	   
//	   public void setAjax(String ajax)  
//	   {  
//	     this.ajax = ajax;  
//	   }  
//	   
//	   public int getStatusCode() {  
//	     return this.statusCode;  
//	   }  
//	   
//	   public void setStatusCode(int statusCode) {  
//	     this.statusCode = statusCode;  
//	   }  
//	   
//	   public String getTipsMessage() {  
//	     return this.tipsMessage;  
//	   }  
//	   
//	   public void setTipsMessage(String tipsMessage) {  
//	     this.tipsMessage = tipsMessage;  
//	   }  
//	   
//	   public String getForwardUrl() {  
//	     return this.forwardUrl;  
//	   }  
//	   
//	   public void setForwardUrl(String forwardUrl) {  
//	     this.forwardUrl = forwardUrl; }  
//	   
//	   public String getTargetType() {  
//	     if ((this.lookup != null) && (this.lookup.length() > 0)) {  
//	       return "dialog";  
//	     }  
//	     return "navTab";  
//	   }  
//	   
//	   private String ajaxForward(int statusCode, String message) {  
//	     this.statusCode = statusCode;  
//	     this.tipsMessage = message;  
//	     return "ajaxDone";   
//	   }  
//	   
//	   /** 
//	    * ajax 提交后跳转 
//	    * @param message 
//	    * @return 
//	    */  
//	   protected String ajaxForwardSuccess(String message) {  
//	     return ajaxForward(200, message);   
//	   }  
//	   
//	   /** 
//	    * ajax 提交失败后跳转 
//	    * @param message 
//	    * @return 
//	    */  
//	   protected String ajaxForwardError(String message) {  
//	     return ajaxForward(300, message);  
//	   }  
	
}
