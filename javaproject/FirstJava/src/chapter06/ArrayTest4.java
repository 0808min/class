package chapter06;

public class ArrayTest4 {

	public static void main(String[] args) {

//		2차원배열 : 1차원배열의 집합
//		int[][] arr 
//		new int[3][4]

		int[][] arr = new int[2][3];

//		arr은 (요수개수가 4개인 1차원배열) 3개를 가지는 배열 인스턴스를 가르킨다
//		1차원 배열의 사이즈는 4개

		System.out.println("2차원 배열의 사이즈 : " + arr.length);

		System.out.println("첫번째 1차원 배열의 사이즈 : " + arr[0].length);
		System.out.println("두번쨰 1차원 배열의 사이즈 : " + arr[1].length);

		arr[0][0] = 11;
		arr[0][1] = 12;
		arr[0][2] = 13;
		arr[1][0] = 21;
		arr[1][1] = 22;
		arr[1][2] = 23;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("arr["+i+"]["+j+"] = " + arr[i][j]);
			}
			System.out.println();
		}

	}

}