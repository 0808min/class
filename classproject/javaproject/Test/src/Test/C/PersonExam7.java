package Test.C;

import java.time.LocalDate;
import java.util.Calendar;

public class PersonExam7 {

	String name;
	String personNumber;

	public PersonExam7(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}
	
	int getAge() {
		
		
		int result = 0;
		
		String tempYear = personNumber.substring(0, 2); // 00, 99
		String tempGender = personNumber.substring(7, 8); // 1,2,3,4
		
		
//		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int curYear = LocalDate.now().getYear();
		
		int birYear = Integer.parseInt(tempYear);
		int genderVal = Integer.parseInt(tempGender);
		
		
		if(genderVal == 1 || genderVal == 2) {
			result = curYear - (1900 + birYear);
		} else if(genderVal == 3 || genderVal == 4) {
			result = curYear - 2000 + birYear;
		}
		
		
		
		return result;
	}
	
	
	
	void printInfo() {
		System.out.printf("안녕하세요 저는 %s입니다. %d살 입니다.",this.name, getAge());
	}
	
	
	public static void main(String[] args) {
		
		LocalDate curDate = LocalDate.now();
		System.out.println(curDate);
		System.out.println(curDate.getYear());
		
		int curYear = LocalDate.now().getYear();
		
		PersonExam7 p = new PersonExam7("주경진", "930705-2000000");
		
	}

}
