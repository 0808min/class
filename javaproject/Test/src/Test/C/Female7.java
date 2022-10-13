package Test.C;

public class Female7 extends PersonExam7 {

	String major;
	int grade;

	public Female7(String name, String personNumber, String major, int grade) {
		super(name, personNumber);
		this.major = major;
		this.grade = grade;
	}

void printSchoolInfo() {
	System.out.printf("전공은 %s이고 %d학년 입니다.", this.major, this.grade);
}

@Override
void printInfo() {
	super.printInfo();
	System.out.println();
	printSchoolInfo();
	
}

}
