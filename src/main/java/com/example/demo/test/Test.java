package com.example.demo.test;

import java.math.BigDecimal;

public class Test {

	
	// 这里我用^代表指数2^3就是2³  2^3^n就是(2³)ⁿ  表达式只支持整数，不支持浮点数
	public static void main(String[] args) {
		String express = "2.1  -1  +2^(3*1)";
		BigDecimal computer = CalculateUtil.Computer(express.replaceAll("\\s", ""));
		System.out.println(computer);
		
	}
}
