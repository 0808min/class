package chapter13;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Runnable 인터페이스를 이용한 스레드 생성과 작업이 진행됩니다.");
//			try {
//				Thread.sleep(500);
//				System.out.println("Runnable 인터페이스를 이용한 스레드 생성과 작업이 진행됩니다."); // 현재 스레드의 상태를 block 상태로 변경
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 

		}
		
	}

}
