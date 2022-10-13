package chapter12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {

		try (BufferedReader in = new BufferedReader(new FileReader("c:\\test\\text2.txt"))) {

			while (true) {

				String str = in.readLine();

				if (str == null) {
					break;
				}

				System.out.println(str);
			}

			System.out.println("프로그램 종료");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
