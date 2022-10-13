package chapter04;

public class SwitchCaesTest3 {

	public static void main(String[] args) {
		
		String grade = "admin"; 
		
		// admin 모두 / manager 쓰기, 읽기, 회원승인 / member 쓰기, 읽기 / anyone 읽기
		
		// 쓰기 / 읽기 / 회원 승인 / 지표 보기
		
		if(grade. equals("admin")) {
			System.out.println("지표보기 기능 가능");
			System.out.println("회원승인");
			System.out.println("쓰기 기능 가능");
			System.out.println("읽기 기능 가능");
		} else if(grade. equals("admin")) {
			System.out.println("지표보기 기능 가능");
			System.out.println("회원승인");
			System.out.println("쓰기 기능 가능");
			System.out.println("읽기 기능 가능");
		} else if(grade. equals("manager")) {
			System.out.println("쓰기 기능 가능");
			System.out.println("읽기 기능 가능");
			System.out.println("회원승인");
		} else if(grade. equals("member")) {
			System.out.println("쓰기 기능 가능");
			System.out.println("읽기 기능 가능");
		} else if(grade. equals("anyone")) {
			System.out.println("읽기 기능 가능");
		}
		
		switch(grade) {
		case "admin" :
			System.out.println("지표보기 기능 가능");
			break;
		case "manager" :
			System.out.println("회원승인");
			break;
		case "member" :
			System.out.println("쓰기 기능 가능");
			break;
		
		default:
			System.out.println();
			
		}
		
	}

}
