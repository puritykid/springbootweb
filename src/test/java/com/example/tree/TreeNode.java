
package com.example.tree;

import java.util.List;

/**
 * 
 * Created by Massive on 2016/12/26.
 * 
 */

public class TreeNode {

	private String id;

	private String parentId;

	private String name;
	
	private String levelCode;

	private List<TreeNode> children;
	

	public TreeNode(String id, String name, String parentId, String levelCode) {

		this.id = id;

		this.parentId = parentId;

		this.name = name;
		
		this.levelCode = levelCode;

	}

	public TreeNode(String id, String name, TreeNode parent,String levelCode) {

		this.id = id;

		this.parentId = parent.getId();

		this.name = name;
		
		this.levelCode = levelCode;

	}

	public String getParentId() {

		return parentId;

	}

	public void setParentId(String parentId) {

		this.parentId = parentId;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getId() {

		return id;

	}

	public void setId(String id) {

		this.id = id;

	}
	
	public String getLevelCode() {

		return levelCode;

	}

	public void setLevelCode(String levelCode) {

		this.levelCode = levelCode;

	}

	public List<TreeNode> getChildren() {

		return children;

	}

	public void setChildren(List<TreeNode> children) {

		this.children = children;

	}

	@Override

	public String toString() {

		return "TreeNode{" +

				"id='" + id + '\'' +

				", parentId='" + parentId + '\'' +

				", name='" + name + '\'' +
				", levelCode='" + levelCode + '\'' +

				", children=" + children +

				'}';

	}

}
