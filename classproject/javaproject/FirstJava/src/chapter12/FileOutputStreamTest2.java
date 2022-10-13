package chapter12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {

	public static void main(String[] args) {

		// 파일에 쓰기위해서는 : OutputStream -> FileOutputStream

		FileOutputStream outputStream = null;

		try {
			// 생성자에 자원의 경로 지정하고 스트림 인스턴스 생성
			outputStream = new FileOutputStream("C:\\test\\testfile1.txt");
			outputStream.write(65); // 쓰기

			outputStream.close();

			System.out.println("파일에 데이터 쓰기 성공!");

		} catch (FileNotFoundException e) {
			System.out.println("해당 경로에 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("출력 오류");
			e.printStackTrace();
		}

	}

}