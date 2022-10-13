package chapter11;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<String, SmartPhone> hashMap = new HashMap<>();

		hashMap.put("Spring", new SmartPhone("Spring", "010-0000-0000"));
		hashMap.put("King", new SmartPhone("King", "010-7777-8888"));

		System.out.println(hashMap.get("king"));

		hashMap.put("Min", new SmartPhone("Min", "010-7771-1230"));
		hashMap.put("King", new SmartPhone("King", "010-7777-7777"));

		System.out.println("----------------------------------");

		System.out.println(hashMap.get("Min"));
		System.out.println(hashMap.get("min"));
		System.out.println(hashMap.get("king"));

		System.out.println("----------------------------------");

//		키 값들을 Set 객체로 받는다
		Set<String> keySet = hashMap.keySet();

		for (String key : keySet) {
//			System.out.println(key);
			System.out.println(key + " = " + hashMap.get(key));
		}

	}

}
