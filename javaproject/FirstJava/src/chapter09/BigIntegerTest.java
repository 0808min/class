package chapter09;

import java.math.BigInteger;

public class BigIntegerTest {
	
	public static void main(String[] args) {
		
		BigInteger bi1 = new BigInteger("10000000000000000000000");
		BigInteger bi2 = new BigInteger("10000000000000000000000");
		
		System.out.println(bi1.add(bi2));
		System.out.println(bi1.subtract(bi2));
		System.out.println(bi1.multiply(bi2));
		System.out.println(bi1.divide(bi2));
		
	}

}
