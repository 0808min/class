package Test.B;

public class Exception3 {

	public static void main (String[] args) {
		try {
			check1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static void check1() throws ClassNotFoundException {
		check2();
	}

	static void check2() throws ClassNotFoundException {

		Class.forName("NULL");

	}

}
