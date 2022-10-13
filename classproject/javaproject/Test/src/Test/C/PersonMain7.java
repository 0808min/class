package Test.C;

public class PersonMain7 {

	public static void main(String[] args) {

		Male7 m = new Male7("박민", "910808-1000000", "민박");
		Female7 f = new Female7("주경진", "930705-2000000", "시각", 4);

		m.printInfo();
		System.out.println();
		m.hi();

		System.out.println();

		f.printInfo();
		System.out.println();
		f.printSchoolInfo();
		
		PersonExam7 p1 = m;
		PersonExam7 p2 = f;
		
		System.out.println();
		System.out.println("-----------------------");
		p2.printInfo();
	}

}
