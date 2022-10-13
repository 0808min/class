package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerializableTest2 {

	public static void main(String[] args) {

		ObjectInputStream inputStream = null;

		try {

			inputStream = new ObjectInputStream(new FileInputStream("instanceData.ser"));

			String str = (String) inputStream.readObject();

			Person p = (Person) inputStream.readObject();

			System.out.println(str);

			p.tell();

			ArrayList<Person> list = (ArrayList<Person>) inputStream.readObject();

			for (Person person : list) {
				person.tell();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}