package com.inga.entity;

import java.io.Serializable;

public class Tree implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4267164110251978239L;

	private String id;
	
	private String pid;
	
	private String lev;
	
	private String op;
	
	private String acturl;
	
	private String name;
	
	private String uptime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getLev() {
		return lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getActurl() {
		return acturl;
	}

	public void setActurl(String acturl) {
		this.acturl = acturl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
