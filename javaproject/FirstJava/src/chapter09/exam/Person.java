package chapter09.exam;

public class Person {

//	1. 위 Person 클래스의 equals() 메소드를 오버라이딩해서 주민등록번호가 같으면 인스턴스로 판별하는 프로그램을 만들어봅시다. 
	String name;
	String personNumber;

	Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;

	}

	@Override
	public boolean equals(Object obj) {

		boolean result = false;

		if (obj != null && obj instanceof Person) {
			Person personNum = (Person) obj;
			result = this.personNumber.equals(personNum.personNumber);

		}

		return result;
	}

	public static void main(String[] args) {

		Person p1 = new Person("min", "910808");
		Person p2 = new Person("min", "910808");
		System.out.println(p1.equals(p2));

	}
	

}
