package chapter06;

public class ArrayTest5 {

	public static void main(String[] args) {

		int[] numbers = { 2, 6, 14, 90, 40 };

		for (int num : numbers) {
			System.out.print(num + "\t");
		}

		int[][] scores = { { 100, 90, 60 }, { 40, 90, 100 }

		};
		System.out.println();
		System.out.println();

		for (int[] temp : scores) {
			
			for (int num : temp) {
				System.out.print(num + "\t");
			}
			System.out.println();
		}

	}

}
