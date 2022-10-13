package Test.B;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<>();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		Iterator<Integer> itr = list.iterator();

		while (itr.hasNext()) {
			Integer integer = itr.next();
			System.out.println(integer);
		}

	}

	static <E> void printAll(LinkedList<Integer> list) {

		for (Integer obj : list) {
			System.out.println(obj);
		}
	}

}
