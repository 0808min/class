package first;

public class PrintMethodTest {
	
	public static void main(String[] args) {
		
		
		// print 메소드 : 매개변수로 전달하는 데이터를 출력
		System.out.print("개인 소개");
		
		// println : 매개변수로 전달된 데이터를 출력하고 개행
		
		System.out.println();
		System.out.print("이름 : 박민");
		System.out.println();
		System.out.println("나이 32");
		System.out.println("직업 : ");
		System.out.println();
		
		// printf("문자열의 규칙, 데이터, 데이터, 데이터")
		// 정수 : %d
		// 문자열 : %s
		// 실수 : %e, %f
		
		// 문자열 저장 변수선언 : String 변수이름 = "박민";
		String userName = "박민";
		int age = 32;
		float height = 174.3f;
		String job = "";
		
		System.out.printf("이름 : %s, 나이 : %d, 키 : %f cm, 직업 : %s", "박민", 32, 174.3f, "");
		
		System.out.println();
		
		System.out.printf("이름 : %s, 나이 : %d, 키 : %f cm, 직업 : %s", userName, age, height, job);
		
		
		
		
	}

}
