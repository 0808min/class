package chapter05;


public class Person {

	private String name;
	private int age;

//	외부에서 변수의 값을 참조 가능 : getter
	public String getName() {
		return name;
	}

//	외부에서 변수의 값을 설정 : setter
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		
		Person p = new Person();
		
		// 참조변수는 주소값을 저장하고 있다.
		System.out.println(p); // 주소값출력?
	}

}
