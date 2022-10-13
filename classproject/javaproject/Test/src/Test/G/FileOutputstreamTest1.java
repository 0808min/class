package Test.G;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputstreamTest1 {
	
	public static void main(String[] args) {
		
		FileOutputStream outputStream = null;
		
		try {
			outputStream = new FileOutputStream("c:\\Test\\testfile3.txt");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
