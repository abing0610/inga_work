package com.inga.action;

import com.opensymphony.xwork2.ActionSupport;

public class SelectShowAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String result;
	
	public String showSelectPro(){
		try {

			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "succ";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
