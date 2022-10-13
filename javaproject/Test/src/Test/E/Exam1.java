package Test.E;

public class Exam1 {

	public static void main(String[] args) {

		int[][] scores = new int[10][3];

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				int num = (int) (Math.random() * 51) + 50;
				scores[i][j] = num;
			}
		}

		System.out.println("성적표");
		System.out.println("=============================================");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println("=============================================");

		int korTotal = 0;
		int engTotal = 0; // for 밖에서
		int matTotal = 0;

		for (int i = 0; i < scores.length; i++) {

			int sum = 0;

			for (int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j] + "\t");
				sum += scores[i][j];

//				국어점수
				if (j == 0) {
					korTotal += scores[i][j];
				}

//				영어점수
				if (j == 1) {
					engTotal += scores[i][j];
				}

//				수학점수
				if (j == 2) {
					matTotal += scores[i][j];
				}

			}

			System.out.print(sum + "\t" + (float) sum / scores[i].length);

			System.out.println();
		}
		System.out.println("=============================================");
		System.out.print(korTotal + "\t" + engTotal + "\t" + matTotal);
		System.out.println();
		System.out.print(
				(float)korTotal/scores.length + "\t" + 
		        (float)engTotal/scores.length + "\t" + 
				(float)matTotal/scores.length);
		
	}
}
