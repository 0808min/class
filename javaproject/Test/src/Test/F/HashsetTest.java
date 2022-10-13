package Test.F;

import java.util.HashSet;
import java.util.Iterator;

public class HashsetTest {
	
	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<>();
		
//		저장
		set.add("박민");
		set.add("주경진");
		set.add("박");
		set.add("주경진");
		set.add("박민");
		
		System.out.println("저장된 요소의 개수 : " + set.size());
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			
			System.out.println(itr.next());
			
		}
		
		
		
		
	}

}
