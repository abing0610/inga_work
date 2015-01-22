package com.inga.dao;

import java.util.List;
import java.util.Map;

import com.inga.entity.Tree;

public interface TreeJsonDAO {

	public List<Tree> getTreeJson();
	
	public void insertTreeNode(Tree tree);
}
