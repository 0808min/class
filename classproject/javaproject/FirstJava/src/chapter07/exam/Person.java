package chapter07.exam;

import java.time.LocalDate;

import chapter03.Exam.Calculator;

class Person {

//	Person 이라는 클래스를 정의해봅시다. 
//	① 이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다.
//	② 인사하는 메소드를 정의해봅시다.
//	- “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다.

	String name;
	String personNumber;

	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	int gerAge() {

		int result = 0;
		

//		나이를 계선해서 반환하는 연산
//		010101=1111111
//		990201-2222222
//		0123456789... 문자열의 index -> 문자열의 위치값
//		태어난 년도 2자리

		String tempYear = personNumber.substring(0, 1); // "00", "99"
		String tempGender = personNumber.substring(7, 8); // 1,2,3,4
		
//      870011-2000000
//      010203-3
//		00 -> 2000년생 이상 -> 년도 -> "00" -> int + 2000
//		99 -> 1900년생 이상 -> 년도 -> "99" -> int + 1900
//		1 || 2 => 1900 + 89
//		3 || 4 => 2000 + 01
		
//		Integer.parseInt("문자열"); => int 정수 반환
		
		
//		나이구하기 : 올해년도 - 태어난년도
		
//		int curYear = Calender.getInstace().get(Calender.YEAR);
//		Date - LocalDate, LocalDatetime, LocalTime
		int curYear = LocalDate.now().getYear();
		
		int birthYear = Integer.parseInt(tempYear);
		int genderVal = Integer.parseInt(tempGender);
		
		if(genderVal == 1 || genderVal == 2) {
			result = curYear - (1900 + birthYear);
			
		} else if(genderVal == 3 || genderVal == 4) {
			result = curYear - 2000 + birthYear;
		}
		
//		2022 - 년도나이

		return result;

	}

	void printInfo() {
		System.out.printf("안녕하세요 ! 저는 %s 입니다.", this.name, 20);
	}
	
	public static void main(String[] args) {
		
		LocalDate curDate = LocalDate.now();
		System.out.println(curDate);
		System.out.println(curDate.getYear());

		
		int curYear = LocalDate.now().getYear();
		
		Person p = new Person("min", "001212-1231231");
		p.printInfo();
		
		
	}

}
