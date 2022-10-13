package chapter07.exam;

import java.time.LocalDate;

public class PersonMain {

	public static void main(String[] args) {

		Male m = new Male("min", "910808-1080000", "mini");
		Female f = new Female("jin", "930000-2000000", "시각", 3);

		m.printInfo();
		m.hi();

		System.out.println();

		f.printInfo();
		System.out.println();
		f.printSchoolInfo();

		Person p1 = m;
		Person p2 = f;

//		p1.hi(); // hi() 는 Person 클래스의 맴버가 아니기떄문에 ㅎ출 불가
//		p2.printSchoolInfo(); printSchoolInfo(); 는 Person 클래스의 맴버가 아니기떄문에 ㅎ출 불가
		System.out.println();
		System.out.println("-------------------------------------");

		p2.printInfo();

	}

}
