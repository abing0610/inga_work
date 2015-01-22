package com.inga.action;

import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSONArray;

import com.inga.common.ServiceAction;
import com.inga.entity.Province;
import com.inga.service.ProvinceService;
import com.opensymphony.xwork2.ActionSupport;

public class ProvinceAction extends ActionSupport {

	/**
	 * 
	 */
	private Logger logger =  Logger.getLogger(ProvinceAction.class);
	
	private static final long serialVersionUID = 7952296448493556698L;
	private String result;

	public String getProvince(){
		
		try {
			
			ProvinceService provinceService =(ProvinceService) ServiceAction.userService("provinceService");
			
			List<Province> list = provinceService.getAllProvince();
			
			JSONArray json = JSONArray.fromObject(list);
			
			result = json.toString();
			
			logger.info(result);
			
			
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
}
