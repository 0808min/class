package chapter03;

public class TernaryOperator {

	public static void main(String[] args) {
		
		int age = 32; // 회원의 나이
		boolean chk = false; // 성인판별 : 성인 -> true, 미성년 -> false
		
		// chk = 상태값(논리값 : 조건식) ? true : false;
		chk = age>19 ? true : false;
		
		
		System.out.println("대상자 판별 : " + chk);
		
		String msg = age>19 ? "성인입니다" : "미성년입니다";
		System.out.println(msg);
		
		int num1 = 2;
		int num2 = 5;
		
		// 큰수 : 같은 수는 없다
		int maxNum = num1 > num2 ? num1 : num2;
		System.out.println("큰수 : " + maxNum);
		
		int minNum = num1 > num2 ? num2 : num1;
		System.out.println("작은수 : " + minNum);
		
		// 홀수 짝수 판별 : 2로 나눈 나머지 값으로 비교
		// 홀수 : 나머지 값 = 1
		// 짝수 : 나머지 값 = 2
		
		String result = num2%2 == 1 ? "홀수 입니다" : "짝수 입니다";  //"홀수" "짝수"
			
		System.out.println("num1의 값은" + result);
		int num3 = -10;
		
		// 양수 음수 0 판단해서 결과 메세지를 출력하는 코드를 작성해보자
		// 먼저 0을 판단
		String msg1	= num3>0 ? "양수입니다" : num3 == 0 ? "0입니다" : "음수입니다";    // "0입니다", "양수 입니다", "음수입니다"
		System.out.println("변수 num3은 " + msg1);
		
		// 절대값
		int resultNum = num3>0 ? num3 : num3==0 ? 0 : -num3;
		System.out.println("num3의 절대값은 " + resultNum);


	}

}
