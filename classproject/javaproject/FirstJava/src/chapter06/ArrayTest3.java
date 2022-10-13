package chapter06;

public class ArrayTest3 {

	public static void main(String[] args) {



//		10명의 국어점수를 저장하는 배열을 선언하고 생성

		int[] korScore = new int[10];

		korScore[0] = 70;
		korScore[1] = 90;
		korScore[2] = 80;
		korScore[3] = 65;
		korScore[4] = 40;
		korScore[5] = 34;
		korScore[6] = 50;
		korScore[7] = 51;
		korScore[8] = 80;
		korScore[9] = 83;

		System.out.println();
		sum(korScore);
		
	}
	
	public static void sum(int[] arr) {
		
//		arr = korScores 의 배열인스턴스 주소
		
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

		}

		System.out.println("총점 : " + sum);
		System.out.println("반 평균 : " + (float) sum / arr.length);

		
	}
	

}
