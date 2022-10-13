package chapter08.Phone;

public class PhoneMain {
	public static void main(String[] args) {

		PhoneImpl phone1 = new PhoneImpl();
		phone1.call();
		phone1.turnOff();
		phone1.turnOn();

		Phone phone01 = phone1;// 형변환 연산 생략
		// 상위 타입인 Phone = new 하위타입인 PhoneImpl
		phone01.turnOn();
		phone01.call();
		phone01.turnOff();
		// System.out.println(phone01.power);

		SmartPhone2 smartPhone2 = new SmartPhone2("hot@gmail.com");
		smartPhone2.turnOn();
		smartPhone2.call();
		System.out.println();
		smartPhone2.appRun("카카오톡");
		System.out.println();
		smartPhone2.appStop("카카오톡");

		Computer phone02 = smartPhone2;
		Phone phone03 = smartPhone2;
		Application phone04 = smartPhone2;

		// .......
		smartPhone2.turnOff();

		SmartPhone3 phone3 = new SmartPhone3("kin@gmail.com");
		phone3.turnOn();
		phone3.call();
		phone3.appRun("네이버");
		phone3.appStop("네이버");

		Phone phone05 = smartPhone2;
		// .......
		phone3.turnOff();

		Phone[] list = new Phone[3];
		list[0] = phone01;
		list[1] = smartPhone2;
		list[2] = phone03;

		for (int i = 0; i < list.length; i++) {
			list[i].turnOn();
		}
	}
}