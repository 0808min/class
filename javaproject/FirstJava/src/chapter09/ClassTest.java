package chapter09;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {

		Class userClass = Class.forName("chapter09.User");

//		변수, 메소드, 생성자

		System.out.println("변수리스트 ---------------------------");
		Field[] fieldList = userClass.getFields();

//		System.out.println(fieldList.length);

		for (Field f : fieldList) {
			System.out.println(f.getName());
		}

		System.out.println("생성자리스트 --------------------------");
		for (Constructor c : userClass.getConstructors()) {
			System.out.println("매개변수 개수 : " + c.getParameterCount());

			for (Class param : c.getParameterTypes()) {
				System.out.println(param.getName());

			}

		}
		
		System.out.println("메소드리스트 ---------------------------");
		for(Method method : userClass.getMethods()) {
			System.out.println(method.getName());
			
		}

	}

}
