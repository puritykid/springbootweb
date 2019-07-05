package com.example.test.learn;

import java.util.ArrayList;
import java.util.List;

import com.example.test.learn.interfaces.Componnent;

/**
 * 数值构建角色类
 * @author haha
 *
 */
public class Composite implements Componnent{

	
	private String name;
	
	
	
	public Composite(String name) {
		this.name = name;
	}

	private List<Componnent> childs = new ArrayList<Componnent>();
	
	
	@Override
	public void pringtStruct(String dir) {
		System.out.println(name);
		for (Componnent child : childs) {
			child.pringtStruct("  ");
		}
	}


	public List<Componnent> getChilds() {
		return childs;
	}

	
	public void addChild(Componnent componnent) {
		this.childs.add(componnent);
	}
	
	public void removeChild(int index) {
		this.childs.remove(index);
	}
	
}
