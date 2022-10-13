package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsTest {

	public static void main(String[] args) {

		List<Integer> lottoNumber = new ArrayList<>();

		Random random = new Random(System.nanoTime());

		for (int i = 0; i < 6; i++) {
			lottoNumber.add(new Random(System.nanoTime()).nextInt(45) + 1);
		}

		for (int n : lottoNumber) {
			System.out.println(n);
		}

		System.out.println("로또번호");
		printAll(lottoNumber);

		System.out.println();

		System.out.println("최대값 : " + Collections.max(lottoNumber));
		System.out.println("최소값 : " + Collections.min(lottoNumber));

		Collections.sort(lottoNumber);
		System.out.println("정렬 ======================================");
		printAll(lottoNumber);

//		역순으로 정렬
		Collections.reverse(lottoNumber);
		System.out.println("역순으로 정렬 ===============================");
		printAll(lottoNumber);

//		섞기
		Collections.shuffle(lottoNumber);
		System.out.println("요소 위치 섞기 : 셔플");
		printAll(lottoNumber);

		List<Integer> list1 = Collections.emptyList();
		System.out.println("리스트 요소의 개수 : " + lottoNumber.size());

	}

	static void printAll(List<Integer> list) {
		for (int n : list) {
			System.out.println(n);
		}

	}

}
