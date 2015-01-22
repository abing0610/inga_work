package com.inga.action;


import com.opensymphony.xwork2.ActionSupport;

public class BackRecordAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public String execute(){
		try {
			
			
			
			
			
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
	}
	
}
