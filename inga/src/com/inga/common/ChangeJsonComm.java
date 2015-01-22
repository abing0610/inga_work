package com.inga.common;

import java.util.List;

import com.inga.entity.Tree;

public class ChangeJsonComm {
	
	/*
	 * @param List<Tree>
	 * @return String(json)
	 * 
	 * @author inga
	 * ��ѯ����tree����Ϣ��Ȼ��ת��Ϊָ������Ϣ
	 * 
	 */
	public static String changeListTreeToStr(List<Tree> list){
		StringBuilder str= new StringBuilder();
		try {
			str.append("[");
			
			for (int i = 0; i < list.size(); i++) {
				Tree tree =(Tree) list.get(i);
				str.append("{id:");
				str.append(tree.getId());
				str.append(",pId:");
				str.append(tree.getPid());
				str.append(",name:\"");
				str.append(tree.getName());
				str.append("\"");
				
				//�жϲ�ѯ���������Ƿ���·�����ڵ�û��·��Ĭ��Ϊ#,�ӽڵ���·�����Լ����塣
				String actUrl = tree.getActurl();
				if(!actUrl.equals("#")){
					str.append(",path:\"");
					str.append(tree.getActurl());
					str.append("\"");
				}
				
				if (i != (list.size()-1)) {
					str.append("},");
				}else {
					str.append("}");
				}
			}
			str.append("]");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return str.toString();
	}

}
