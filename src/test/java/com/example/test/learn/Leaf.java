package com.example.test.learn;

import com.example.test.learn.interfaces.Componnent;

public class Leaf  implements Componnent{

	
	private String name;
	
	public Leaf(String name) {
		this.name = name;
	}



	@Override
	public void pringtStruct(String name) {

		System.out.println(name + this.name);
	}

}
