package chapter04;

public class WhileLoop3 {
	
	public static void main(String[] args) {
		
		
		//1 ~ 10까지의 합 => 55
		
		// 반복 10번 or 변수가 1 ~ 10
		
		int num = 1;
		
		int sum = 0;
		
		while(num<=100) {
			
			// 합을 구하는 연산
			sum = sum + num; //  ((((0+1)+2)+3)......+10)
			
			// 증가식
			num++;
		}
		System.out.println("1~10 까지의 합 : " + sum);
	}

}
