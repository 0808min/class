package chapter04;

public class SwitchCaseTest2 {
	
	public static void main(String[] args) {
		
		
		
		// 90점 이상 : A 90~100 score / 10 = 9, 10
		// 80점 이상 : B 80~89 score / 10 = 8
		// 70점 이상 : C 70~79 score / 10 = 7
		// 70점 미만 : F 69 이하 score
		
		int score = 90;
		char c = 'A';
		
		// key : int 가능한 숫자, String
		// key : byte, short, int, char
		switch (score/10) {
		/*case 10: 
			System.out.println("A");
			break;*/
		case 9: case 10:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("F");
		
		}
		
	}

}
