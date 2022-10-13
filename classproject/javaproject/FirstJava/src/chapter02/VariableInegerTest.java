package chapter02;

public class VariableInegerTest {
	
	public static void main(String[] args) {
		
		
		// 정수 : byte   stort  int(기본타입)   long
		//       1byte  2byte  4byte         8byte
		
		int num = 100;
		
		byte bytenum1 = 10;
		byte bytenum2 = 127;
		byte bytenum3 = (byte)200;
		
		System.out.println(bytenum1);
		System.out.println(bytenum2);
		System.out.println(bytenum3);
		
		
		long longnum1 = 2200000000L;
		
		int num1 = 100000;
		int num2 = 100000;
		
		// 곱 연산
		long result = (long)num1 * num2;  // long * long => long
		
		System.out.println(result);
	
		
		
		
	}

}
