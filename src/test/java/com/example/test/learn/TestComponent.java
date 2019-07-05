package com.example.test.learn;

public class TestComponent {

	
	public static void main(String[] args) {
		
		Composite root = new Composite("D盘");
		
		Composite dir2 = new Composite("文件夹");
		Leaf leaf1 = new Leaf("a.txxt");
		Leaf leaf2 = new Leaf("b.txxt");
		Leaf leaf3 = new Leaf("c.txxt");
		dir2.addChild(leaf1);
		dir2.addChild(leaf2);
		dir2.addChild(leaf3);
		
		Composite dir3 = new Composite("图片");
		Leaf leaf4 = new Leaf("a.jpg");
		Leaf leaf5 = new Leaf("b.peg");
		dir3.addChild(leaf4);
		dir3.addChild(leaf5);
		
		root.addChild(dir2);
		root.addChild(dir3);
		
		root.pringtStruct(" ");
	}
}
