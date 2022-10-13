package chapter09;

import java.util.Calendar;

public class CalendarTest {
	
	public static void main(String[] args) {
		
		Calendar cal1 = Calendar.getInstance();
//		System.out.println(call);
		
		System.out.println(cal1.getTime());
		System.out.println(cal1.getTimeInMillis());
		
//		현재시간에서 1시간 증가
		cal1.add(Calendar.HOUR, 1);
		System.out.println(cal1.getTime());
		
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
//		현재 날짜 정보가 아닌 특정날짜와 시간 지정
		cal2.set(2002, 5, 7);
		cal3.set(2000, 0, 1, 0, 0, 1);
		
		System.out.println(cal2.getTime());
		System.out.println(cal3.getTime());
		
//		cal1 2022, cal3 2000
		System.out.println(cal1.before(cal3));
		System.out.println(cal1.after(cal3));
		
	}

}
