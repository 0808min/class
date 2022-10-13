
package chapter06.Exam;

import chapter06.Exam.Student;

public class StudentMain {

	public static void main(String[] args) {

//		학생 10명의 정보를 저장하는 배열
		Student[] students = new Student[10];

//		점수 초기화
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student("학생" + i, (int) (Math.random() * 51) + 50, 
					(int) (Math.random() * 51) + 50,
					(int) (Math.random() * 51) + 50);

		}
		
		int engTotalScore = 0;
		int korTotalScore = 0;
		int matTotalScore = 0;
		
		
		System.out.println("성적표");
		System.out.println("---------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------------");
		
		for (Student s : students) {
			s.printData();
			korTotalScore += s.getKorScore();
			engTotalScore += s.getEngScore();
			matTotalScore += s.getMatScore();

		}
		
		System.out.println("----------------------------------------------------");
		System.out.printf("과목총점 \t %d \t %d \t %d \n", korTotalScore, engTotalScore, matTotalScore);
		System.out.printf("과목평균 \t %f \t %f \t %f \n", korTotalScore/10f, engTotalScore/10f, 
				matTotalScore/10f);
		System.out.println("----------------------------------------------------");

	}

}
