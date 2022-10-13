package chapter13;

// 스레드 클래스 정의 : Thread 클래스를 상속해서 run() 메소드를 오버라이딩
public class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Runnable 인터페이스를 이용한 스레드 생성과 작업이 진행됩니다.");
//			try {
//				Thread.sleep(500);
//				System.out.println("새로운 스레드가 생성되어 실행합니다.");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		}
		
	}

}
