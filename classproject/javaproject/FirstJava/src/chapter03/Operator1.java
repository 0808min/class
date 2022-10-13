package chapter03;

public class Operator1 {
	
	public static void main(String[] args) {
		
		// 대입연산자 : = => 오른쪽에서 왼쪽으로 연산이 진행
		// 순서는 가장 마지막
		
		int num1 = 10;
		num1 = 10 + 20;
		
		boolean check = num1-27 > 5; // 비교연산의 결과는 논리값
		
		// 단향연산자 : 오른쪽에서 왼쪽으로 연산
		
		int num = 0;
		System.out.println(num);
		// 증강연산자 : ++ --
		++num; // num = num +1; num = 0 + 1; num = 1; 
		System.out.println(num);
		
		num++; // num = num + 1; -> num = 1 + 1; -> num = 2;
		System.out.println(num);
		
		--num; // num = num - 1; -> num = 2 - 1; -> num = 1;
		System.out.println(num);
		
		num--; // num = num - 1; -> num = 1 - 1; -> num = 0;
		System.out.println(num);
		
		// 부호 연산자
		// +, -
		int num2 = 1;
		num2 = +num2;
		System.out.println("num2 : " + num2);
		
		num2 = -num2;  // num2 * -1
		System.out.println("num2 : " + num2);
		
		// 논리 부정 연산자 : ! => 논리값을 부정
		boolean btn = false;
		
		System.out.println("btn : " + btn);
		
		btn = !btn;
		System.out.println("btn : " + btn);

	}

}
