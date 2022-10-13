package chapter04.Exam;

public class Exam04 {

	public static void main(String[] args) {
		/* 문제 4
		다음 식을 만족하는 조합을 찾는 프로그램 작성. 
		A B / 10의 자리 A / 1의 자리 B
		B A + / 10의 자리 B / 1의 자리 A
		10A + B + 10B + A
		------
		9 9
		A와 B의 값의 조합들을 찾아보자
		11A + 11B = 99 => A+B=9 => B = 9-A
		각각의 자리수 : 0~9
		*/
		
		for(int i=0; i<10; i++) {
			System.out.println("A: " + i + "일때, B: " + (9-i));
		}
		

	}

}
