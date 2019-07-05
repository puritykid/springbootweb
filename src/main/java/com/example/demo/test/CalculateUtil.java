package com.example.demo.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

/**
 * 计算结果
 * @author 24460
 *
 */
public class CalculateUtil {

	public static BigDecimal Computer(String inputExpress) {
		
		String express = ParseExpress.converExpress(inputExpress);
		
		if (express == null || express.length() == 0) {
			return null;
		}
		System.out.println(express);
		Stack<BigDecimal> val = new Stack<BigDecimal>();
		char[] charArray = express.toCharArray();
		
		for (char ch : charArray) {
			if (ch >= '0' && ch <= '9') {
				val.push(new BigDecimal((ch - '0')));
			} else {
				val.push(getResult(ch, val.pop(), val.pop()));
			}
		}
		
		return val.pop();
	}
	
	/**
	 * 计算结果
	 * @param operator
	 * @param val1
	 * @param val2
	 * @return
	 */
	private static BigDecimal getResult(char operator,BigDecimal val1,BigDecimal val2) {
		switch (operator) {
		case OperateMark.ADD:
			return val2.add(val1); 
		case OperateMark.SUBSTRACT:
			return val2.subtract(val1); 
		case OperateMark.MULTIPLE:
			return val2.multiply(val1); 
		case OperateMark.DEVIDE:
			return val2.divide(val1,2,RoundingMode.HALF_DOWN);  // 去尾默认保留小数点后两位
		case OperateMark.INDEX:
			return val2.pow(val1.intValue());
		default:
			return BigDecimal.ZERO;
		}
	}
	
	
}
