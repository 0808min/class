package chapter09.exam;

public class Exam2Main {

	public static void main(String[] args) {

//		2. 1~100,000,000까지 더하기하는 연산의 
//		실행 시간을 측정하는 프로그램을 만들어봅시다. 
		
		long startTime = System.currentTimeMillis();
		System.out.println("시작 시간 : " + startTime);

		int sum = 0;
		for (int i = 1; i <= 100000000; i++) {
			sum += i;

		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("종료 시간 : " + endTime);
		
		System.out.println("1~100.000.000의 합은 : " + sum);
		System.out.println("연산의 소요 시간 : " + (endTime-startTime));

	}

}
