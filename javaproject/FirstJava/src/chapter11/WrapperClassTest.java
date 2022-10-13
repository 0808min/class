package chapter11;

import java.util.ArrayList;

public class WrapperClassTest {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10);  // 오토박싱
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		printAll(list);
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Park");
		list2.add("Min");
		
		
		printAll(list2);
		
		
	}
	
	static <E> void printAll(ArrayList<E> list) {
		
		for (E obj : list) {
			System.out.println(obj);
			
		}
		
	}

}
