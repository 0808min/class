package chapter09;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {

		BigDecimal bd1 = new BigDecimal("1.8");
		BigDecimal bd2 = new BigDecimal("1.2");
		
		System.out.println(bd1.add(bd2));
		System.out.println(bd1.subtract(bd2));
		System.out.println(bd1.multiply(bd2));
		System.out.println(bd1.divide(bd2));
		//System.out.println(1.8/1.2);
	}

}