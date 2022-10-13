package chapter04;

public class ForLoopTest {

	public static void main(String[] args) {
		
		//2단
				// 2 x 1 = 2
				// 2 x 2 = 4
				// .....		
				// 2 x 9 = 18
		//3단
				// 3 x 1 = 3
				// 3 x 2 = 6
				// .....		
				// 3 x 9 = 27
	    //9단    // 9 x 1 = 9
                // 9 x 2 = 18
                // .....
                // 9 x 1 = 81
		
		        // 단의 반복 : 2~9
		for(int i=2; i<=9; i++) {
			System.out.println(i + "단");
			System.out.println("-----------");
			
			for(int j=1; j<=9; j++) {
				System.out.println(i +" x " + i*j);
				
			}
			
			System.out.println("-----------");
		}
		
//		for(int i=1; i<=9; i++ ) {
//			System.out.println("2 x " + i + " = " + (2*i) );
//		}

	}

}
