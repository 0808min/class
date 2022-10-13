package chapter03;

public class PrefixOperator {
	
	public static void main(String[] args) {
		
		int num1 = 5;
		
		System.out.println("num1 : " + num1);
		
		int num2 = ++num1; // num1 = num + 1 -> num2 = num1;
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		System.out.println("num1 : " + ++num1);
	}

}
