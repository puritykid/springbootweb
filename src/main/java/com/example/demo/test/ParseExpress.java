package com.example.demo.test;

import java.util.Stack;


/**
 * 转化表达式
 * @author chenxiaojun
 *
 */
public class ParseExpress {
	
	private final static Stack<Character> operateMarks = new Stack<Character>(); 

	public static String converExpress(String inputExpress) {
		StringBuffer sb = new StringBuffer();
		if (inputExpress == null || inputExpress.length()==0) {
			return sb.toString();
		}
		
		char[] charSequence = inputExpress.toCharArray();
		
		for (Character ch : charSequence) {
			
			if (ch == ' ') {
				continue;
			}
			
			if (ch >= '0' && ch<= '9') {
				sb.append(ch);
				continue;
			}
			
			if (ch == '+' || ch == '-') {
				while (!operateMarks.isEmpty() && (operateMarks.peek() != '(')) {
					sb.append(operateMarks.pop());
				}
				operateMarks.push(ch);
				continue;
			}
			
			if (ch == '*' || ch == '/') {
				while (!operateMarks.isEmpty() && (operateMarks.peek() == '*' || operateMarks.peek() == '/')) {
					sb.append(operateMarks.pop());
				}
				operateMarks.push(ch);
				continue;
			}
			
			if (ch == '(') {
				operateMarks.push(ch);
				continue;
			}
			
			// 指数
			if (ch == '^') {
//				2+2^3
//				223^+
//				step        stack    sb
//				1                    2
//				2             +      2
//				3             +      22
//				4             +^     22
//				5             +^     223
//				6                    223^+
				operateMarks.push(ch);
				continue;
			}
			
			if (ch == ')') {
				while (!operateMarks.isEmpty() && (operateMarks.peek() != '(')) {
					sb.append(operateMarks.pop());
				}
				operateMarks.pop();
				continue;
			}
		}
		// 将剩余栈中元素都出栈
		while (!operateMarks.isEmpty()) {
			sb.append(operateMarks.pop());
		}
		return sb.toString();
	}
	
}
