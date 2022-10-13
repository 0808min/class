package chapter06.Exam;

public class Exam1 {

	public static void main(String[] args) {

//		국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 
//		점수를 모두 출력하고, 
//		평균 점수를 출력하는 프로그램을 작성해봅시다.

		int[][] scores = new int[10][3];

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
//				System.out.println(scores[i][j]);
				int num = (int) (Math.random() * 51) + 50; // 0 <= num < 51
				scores[i][j] = num;
			}
		}

		System.out.println("성적표");
		System.out.println("===========================================");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println("===========================================");

		int korTotal = 0;
		int engTotal = 0;
		int matTotal = 0;

		for (int i = 0; i < scores.length; i++) {

			int sum = 0;

			for (int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j] + "\t");
				sum += scores[i][j];

//				영어 점수일 때
				if (j == 0) {
					korTotal += scores[i][j];
				}

//				국어 점수일 때
				if (j == 1) {
					engTotal += scores[i][j];
				}

//				수학 점수일 때
				if (j == 2) {
					matTotal += scores[i][j];
				}

			}

			System.out.print(sum + "\t" + (float) sum / scores[i].length);

			System.out.println();
		}
		
		System.out.println("============================================");
		System.out.print(korTotal + "\t" + engTotal + "\t" + matTotal + "\t");
		System.out.println();
		System.out.print((float) korTotal / scores.length + "\t" + (float) engTotal / scores.length + "\t"
				+ (float) matTotal / scores.length);

	}

}
