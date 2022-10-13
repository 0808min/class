package first;

public class Member {
	
	public static void main(String[] args) {
		
		// class 파일의 실행 포인트
		printMyName("박민");
		printMyName("박민");
		
	}
	
	// 자기 자신의 이름을 출력하는 메소드
	// 반환타입 : 없다 => void
	// 매개변수 : 없다 
	// 처리내용 : 자신의 이름을 출력한다
	
	public static void printMyName(String name)  {
		
		System.out.println("안녕하세요! " + name + " 입니다. 반갑습니다.");
		
		// 반환이 있다 -> return 사용해서 데이터 반환

	}
}
