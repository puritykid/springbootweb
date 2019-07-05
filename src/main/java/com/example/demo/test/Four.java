
package com.example.demo.test;

/**
 * 表达式
 * 
 * @author 风华褚胜--刘胜军
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Four {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入标准表达式(exit退出)：");
		System.out.println();
		String str = sc.nextLine();
		while (!str.equals("exit")) {
			if (judge_kuohao(str)) {
				System.out.println("括号匹配成功！");
				System.out.println(jisuan(getHouzhui(f(str))));
			} else {
				System.out.println("括号匹配不成功，或者包含不规则括号！");
			}
			System.out.println("请输入标准表达式(exit退出)：");
			str = sc.nextLine();
		}
	}

	/**
	 * 
	 * @param str
	 *            传入的完整算术表达试字符串
	 * @return 返回boolean值，如果匹配成功，返回true，反之false
	 */
	public static boolean judge_kuohao(String str) {
		Stack<Character> s = new Stack<Character>();
		/**********************************/
		char[] ch = new char[128];
		ch['1'] = '1';
		ch['2'] = '2';
		ch['3'] = '3';
		ch['4'] = '4';
		ch['5'] = '5';
		ch['6'] = '6';
		ch['7'] = '7';
		ch['8'] = '8';
		ch['9'] = '9';
		ch['0'] = '0';
		ch['('] = '(';
		ch[')'] = ')';
		ch['['] = '[';
		ch[']'] = ']';
		ch['{'] = '{';
		ch['}'] = '}';
		ch['.'] = '.';
		ch['+'] = '+';
		ch['-'] = '-';
		ch['*'] = '*';
		ch['/'] = '/';
		/**********************************/
		for (int i = 0; i < str.length(); i++) {
			char t = str.charAt(i);
			if (t > 128 || ch[t] != t) {
				return false;
			}
			if (t == '(' || t == '[' || t == '{') {
				s.push(t);
			} else if (t == ')' || t == ']' || t == '}') {
				char temp = '\u0000';
				if (s.size() > 0)
					temp = s.pop();
				else
					return false;
				if (!((temp == '(' && t == ')') || (temp == '[' && t == ']') || (temp == '{' && t == '}'))) {
					return false;
				}
			} else {

			}
		}
		if (s.size() != 0)
			return false;
		return true;
		/**********************************/
	}

	/**
	 * 
	 * @param str  解析传入的完整表达式字符串
	 * @return 完整算术表达试字符串中每个元素组合而成的数组
	 */
	public static Object[] f(String str) {
		Stack<Object> s = new Stack<Object>();
		int left = 0, right = 0, tag = ((str.charAt(0) >= '0' && str.charAt(0) <= '9')
				|| (str.charAt(0) == '.') ? 0 : 1);
		for (int i = 0; i < str.length(); i++) {
			char t = str.charAt(i);
			if ((t >= '0' && t <= '9') || (t == '.')) {
				right++;
				tag = 0;
			} else {
				if (left != right) {
					s.push(new Double(str.substring(left, right)));
					left = right;
				}
				right++;
				s.push(str.substring(left, right));
				left = right;
				tag = 1;
			}
			if (right == str.length()) {
				if (left != right) {
					if (tag == 1)
						s.push(str.substring(left, right));
					else
						s.push(new Double(str.substring(left, right)));
					left = right;
				}
			}
		}
		System.out.println(Arrays.toString(s.toArray()));
		return s.toArray();
	}

	/**
	 * 获取后缀表达式
	 * 
	 * @param f
	 *            完整算术表达试字符串中每个元素组合而成的数组
	 * @return 后缀表达式数组
	 */
	
	/**
	 * 数组转换成后缀表达式思路
	 * 1.定义两个栈，s表示操作符栈，n表示后缀表达式栈
	 * 2.遍历数组
	 * 3.如果是左括弧，将左小括弧放入操作符栈
	 * 4.如果是*操作符，判断操作栈的上一个元素是不是/操作符，如果是将/操作符出栈存入后缀表达式，如果不是直接将*操作符直接存入操作符栈
	 * @param f
	 * @return
	 */
	public static Object[] getHouzhui(Object[] f) {
		// 操作符栈
		Stack<Object> s = new Stack<Object>();
		// 后缀表达式栈
		Stack<Object> n = new Stack<Object>();
		for (int i = 0; i < f.length; i++) {
			if (f[i].equals("(") || f[i].equals("[") || f[i].equals("{")) {
				s.push("(");
			} else if (f[i].equals("*")) {
				while ("/".equals((s.size() > 0) ? s.lastElement() : "")) {
					n.push(s.pop());
				}
				s.push("*");
			} else if (f[i].equals("/")) {
				while ("*".equals((s.size() > 0) ? s.lastElement() : "")) {
					n.push(s.pop());
				}
				s.push("/");
			} else if (f[i].equals("+")) {
				while (("*".equals((s.size() > 0) ? s.lastElement() : ""))
						|| ("/").equals((s.size() > 0) ? s.lastElement() : "")
						|| ("-").equals((s.size() > 0) ? s.lastElement() : "")) {
					n.push(s.pop());
				}
				s.push("+");
			} else if (f[i].equals("-")) {
				while (("*".equals((s.size() > 0) ? s.lastElement() : ""))
						|| ("/").equals((s.size() > 0) ? s.lastElement() : "")
						|| ("+").equals((s.size() > 0) ? s.lastElement() : "")) {
					n.push(s.pop());
				}
				s.push("-");
			} else if (f[i].equals(")") || f[i].equals("]") || f[i].equals("}")) {
				while (!"(".equals((s.size() > 0) ? s.lastElement() : "")) {
					n.push(s.pop());
				}
				s.pop();
			} else {
				n.push(f[i]);
			}
		}
		while (s.size() > 0)
			n.push(s.pop());
		System.out.println(n.toString());
		return n.toArray();
	}

	/**
	 * 计算
	 * 
	 * @param f
	 * @return
	 */
	public static double jisuan(Object[] f) {
		Stack<Object> s = new Stack<Object>();
		for (int i = 0; i < f.length; i++) {
			if (f[i] instanceof Double) {
				s.push(f[i]);
			} else if ("+".equals(f[i])) {
				double left = (double) s.pop();
				double right = (double) s.pop();
				s.push(jia(right, left));
			} else if ("-".equals(f[i])) {
				double left = (double) s.pop();
				double right = (double) s.pop();
				s.push(jian(right, left));
			} else if ("*".equals(f[i])) {
				double left = (double) s.pop();
				double right = (double) s.pop();
				s.push(cheng(right, left));
			} else if ("/".equals(f[i])) {
				double left = (double) s.pop();
				double right = (double) s.pop();
				s.push(chu(right, left));
			} else {

			}
		}
		return (double) s.pop();
	}

	public static double jia(double a, double b) {
		return a + b;
	}

	public static double jian(double a, double b) {
		return a - b;
	}

	public static double cheng(double a, double b) {
		return a * b;
	}

	public static double chu(double a, double b) {
		return a / b;
	}
}
