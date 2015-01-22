package com.inga.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.inga.dao.ProvinceDAO;
import com.inga.dao.SuperDAO;
import com.inga.entity.Province;

@Component("provinceDAO")
public class ProvinceDAOImpl extends SuperDAO implements ProvinceDAO {

	@Override
	public List<Province> getAllProvince() {
		List<Province> list = new ArrayList<Province>();
		try {
			
			list = this.getSqlSession().selectList(Province.class.getName() + ".getAllProvince");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	
}
