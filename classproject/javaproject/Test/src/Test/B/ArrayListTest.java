package Test.B;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
//		List<String> list1 = new ArrayList<String>();
//		List<String> list2 = new ArrayList<>();

//		저장
		list.add("박민");
		list.add("주경진");
		list.add(new String("민"));

//		개수
		System.out.println("저장된 요소의 개수 : " + list.size());

//		참조
		System.out.println(list.get(0));
		printAll(list);
		
		list.add(1, "박");
	
		printAll(list);
		
//		삭제
		list.remove(1);

		printAll(list);
		System.out.println(list.get(1));
//		일괄
		System.out.println("전체 리스트 출력");
		for(String name : list) {
			System.out.println(name);
		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//
//		}

	}
	
	static void printAll(List<String> list) {
		
		
		
	}

}
