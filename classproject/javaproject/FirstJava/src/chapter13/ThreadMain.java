package chapter13;

public class ThreadMain {

//	메인 스레드 실행 시점
	public static void main(String[] args) {

//		새로운 일의 흐름을 생성 -> 스레드 생성
		MyThread thread1 = new MyThread(); // new

//		스레드의 실행 : 흐름이 생성되고, run() 실행
		thread1.start();

//		Runnable 객체를 이용한 스레드 생성 실행
		MyThread2 t = new MyThread2();
		Thread thread2 = new Thread(t);

//		Thread 실행
		thread2.start();
//		thread2.start();
		
		try {
			thread2.join();
			thread1.join(); // 1 스레드가 종료 될 때 까지 다른 스레드를 block 상태로 처리
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println("프로그램 종료");
	}

}
