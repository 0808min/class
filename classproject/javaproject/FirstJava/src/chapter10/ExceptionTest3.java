package chapter10;

import java.util.Scanner;

public class ExceptionTest3 {

	public static void main(String[] args) {

//		Scanner sc = null;
//		try {
//			sc = new Scanner(System.in);
//				......
//		} finally {
//			if (sc != null) {
//				sc.close();
//			}
//		}

		try (Scanner sc = new Scanner(System.in);) {

		} catch (Exception e) {

		}

	}

}
