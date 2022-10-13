package chapter02;

public class VariableCharType {
	
	public static void main(String[] args) {
		
		
		// 문자타입 : char -> 2byte
		// 유니코드 숫자를 저장 : 실제 메모리 저장 숫자가 저장
		
		char ch1 = 'A';
		
		int codeNumber = ch1 + 0;  // 덧셈 연산 int + int
		
		System.out.println(ch1 + " : " + codeNumber);
		
		char ch2 = 66;
		
		System.out.println(ch2);
		
		char ch3 = 51088;
		
		System.out.println(ch3);
		
	
	}

}
