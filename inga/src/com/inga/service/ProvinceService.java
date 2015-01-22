package com.inga.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inga.dao.ProvinceDAO;
import com.inga.entity.Province;

@Service("provinceService")
public class ProvinceService {

	private ProvinceDAO provinceDAO;
	
	public List<Province> getAllProvince(){
		List<Province> list = new ArrayList<Province>();
		try {
			
			list = this.provinceDAO.getAllProvince();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public ProvinceDAO getProvinceDAO() {
		return provinceDAO;
	}

	@Resource(name="provinceDAO")
	public void setProvinceDAO(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}
	
}
