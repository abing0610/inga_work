package com.inga.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.inga.dao.SuperDAO;
import com.inga.dao.TreeJsonDAO;
import com.inga.entity.Tree;

@Component("treeJsonDAO")
public class TreeJsonDAOImpl extends SuperDAO implements TreeJsonDAO {

	@Override
	public List<Tree> getTreeJson() {
		
		List<Tree> list = new ArrayList<Tree>();
		
		try {
			
			list = this.getSqlSession().selectList(Tree.class.getName() + ".getTreeJson");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void insertTreeNode(Tree tree) {
		// TODO Auto-generated method stub
		try {
			
			this.getSqlSession().insert(Tree.class.getName()+".insertTreeNode", tree);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
