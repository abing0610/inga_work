package com.inga.action;

import com.inga.common.BaseAction;

public class TestAction extends BaseAction {

	private String t;
	
	public String test(){
		this.t = t;
		
		System.out.println(" ---   " + t + " ------ ");
		
		System.out.println("this is the test action scoket!!!");
		
		return "succ";
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}
	
	
	
}
