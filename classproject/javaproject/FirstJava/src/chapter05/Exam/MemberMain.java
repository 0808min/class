package chapter05.Exam;

import chapter05.SmartPhone;

public class MemberMain {
	
	public static void main(String[] args) {
		
		Member m1 = new Member(
				"Son", // 
				"010-1111-2222", 
				"축구", 
				1, 
				"son@gmail.com", 
				20000101, 
				"런던"
				);
		m1.showMemberInfo();
		
		Member m2 = new Member(
				"손흥민", // 
				"010-9999-7777", 
				"체육", 
				4, 
				"sonKing@gmail.com"
				);
		m2.showMemberInfo();
	}

}