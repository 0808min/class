package chapter12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableTest {

	public static void main(String[] args) {

		String msg = "안녕하세요123";

		ObjectOutputStream outputStream = null;

		try {

			outputStream = new ObjectOutputStream(new FileOutputStream("instanceData.ser"));

			outputStream.writeObject(msg);

			Person p = new Person("손흥민", 20);

			outputStream.writeObject(p);

			ArrayList<Person> list = new ArrayList<>();
			list.add(new Person("손흥민1", 21));
			list.add(new Person("손흥민2", 22));
			list.add(new Person("손흥민3", 23));
			list.add(new Person("손흥민4", 24));
			list.add(new Person("손흥민5", 25));

			outputStream.writeObject(list);

			System.out.println("저장 되었습니다.");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}