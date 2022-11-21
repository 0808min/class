package potato.util;

import java.util.Scanner;

/**
 * Scanner 관련 입력 처리는 해당 클래스를 호출해주시면 됩니다.
 * 정규식 표현이나 예외 처리를 할 경우 별도의 static 함수 생성 후 작업(되도록이면 공통적으로 처리 가능하게!
 */
public class InputString {
	final static int STRING_LEN_255 = 255;
	
	public static Scanner scan = new Scanner(System.in);
	
	public static int inputInt() {
		int result = -1;
		while(true) {
			try {
				result = Integer.parseInt(scan.nextLine());
				break;
			} catch(Exception e) {
				System.out.println("입력 형식이 잘못 되었습니다. 숫자 형식으로 다시 입력해주세요.");
				continue;
			}
		}
		return result;
	}
	
	public static String inputDefaultString() {
		String result = null;
		
		while(true) {
			result = scan.nextLine();
			if(result.trim().length() != 0 && result.getBytes().length < STRING_LEN_255 ) {
				break;
			}
			System.out.println("입력된 문자의 길이가 깁니다. 다시 입력해주세요.");
		}
		
		return result;
	}

}
