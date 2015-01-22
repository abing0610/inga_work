package com.inga.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inga.dao.TreeJsonDAO;
import com.inga.entity.Tree;


@Service("treeJsonService")
public class TreeJsonService {

	private TreeJsonDAO treeJsonDAO;
	
	public List<Tree> getTreeJson() {
		List<Tree> list = new ArrayList<Tree>();
		try {
			
			list = this.treeJsonDAO.getTreeJson();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void insertTreeNode(Tree tree){
		
		this.treeJsonDAO.insertTreeNode(tree);
	}

	public TreeJsonDAO getTreeJsonDAO() {
		return treeJsonDAO;
	}

	@Resource(name="treeJsonDAO")
	public void setTreeJsonDAO(TreeJsonDAO treeJsonDAO) {
		this.treeJsonDAO = treeJsonDAO;
	}
	
	
}
