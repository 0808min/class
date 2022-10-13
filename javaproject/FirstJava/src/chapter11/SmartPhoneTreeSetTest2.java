package chapter11;

import java.util.TreeSet;

public class SmartPhoneTreeSetTest2 {

	public static void main(String[] args) {

		TreeSet<SmartPhone> set = new TreeSet<>();

		set.add(new SmartPhone("JAVA", "010-0000-1111"));
		set.add(new SmartPhone("PARK", "010-3333-2222"));
		set.add(new SmartPhone("String", "010-0400-1111"));
		set.add(new SmartPhone("King", "010-1111-3333"));
		set.add(new SmartPhone("Scott", "010-3433-2222"));
		set.add(new SmartPhone("Min", "010-0000-1111"));

		System.out.println("요소의 개수 : " + set.size());

		for (SmartPhone sp : set) {
			System.out.println(sp);
		}

	}

}
