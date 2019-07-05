package com.example.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.example.tree.TreeBuilder;
import com.example.tree.TreeNode;

public class Test {
	public static void main(String[] args) throws ParseException {
		
		
		List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
		TreeNode node1 = new TreeNode("1", "中瑞公司", "0", "0.");
		TreeNode node2 = new TreeNode("2", "中瑞金服", "1" ,"0.1.");
		TreeNode node3 = new TreeNode("3", "共享研发部", "2", "0.1.1.");
		TreeNode node4 = new TreeNode("4", "金服产品部", "2", "0.1.2.");
		TreeNode node5 = new TreeNode("5", "中瑞智投", "1", "0.2.");
		TreeNode node6 = new TreeNode("6", "智投财务部", "5", "0.1.5.");
		TreeNode node7 = new TreeNode("7", "基础服务组", "3", "0.2.3.7.");
		
		treeNodeList.add(node1);
		treeNodeList.add(node2);
		treeNodeList.add(node3);
		treeNodeList.add(node4);
		treeNodeList.add(node5);
		treeNodeList.add(node6);
		treeNodeList.add(node7);
		
		List<TreeNode> trees = TreeBuilder.bulid(treeNodeList);
		String json = JSON.toJSONString(trees);
		System.out.println(json);
		
		
		String datestr = "2019-07";
		

	}

}
