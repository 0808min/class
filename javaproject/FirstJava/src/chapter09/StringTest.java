package chapter09;

public class StringTest {

	public static void main(String[] args) {

//		문자를열 다루는 String
		String str1 = "String";
		String str2 = "String";
		String str3 = new String("String");

		System.out.println("str1 == str2 => " + (str1 == str2));
		System.out.println("str1 == str3 => " + (str1 == str3));

		System.out.println(str1.equals(str3));

//		특정 타입의 데이터 -> 문자열 String 타입으로 변경
		String str4 = "" + 1;
		String str5 = String.valueOf(false);
		String str6 = new String();
		System.out.println(str5);
	}

}
