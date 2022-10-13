package chapter09;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTest {

	public static void main(String[] args) {
		
//		jdk 1.8 : LocalDate, LocalDataTime, LocalTime
//		현재 날짜를 가져와보자
		LocalDate now = LocalDate.now();
		System.out.println(now);
		System.out.println(now.getYear()); // 년도반환
		System.out.println(now.getMonthValue());
		System.out.println(now.getMonth());
		System.out.println(now.getDayOfWeek());
		System.out.println(now.getDayOfMonth());
		
		LocalDate nextDay = now.plusDays(1).plusMonths(1).plusYears(1); // 마이너스도 있다
		System.out.println(nextDay);
		
		System.out.println("-----------------------------------------");
		LocalTime now1 = LocalTime.now();
		System.out.println(now1);
		
		System.out.println(now1.getHour());
		System.out.println(now1.getMinute());
		System.out.println(now1.getSecond());
		System.out.println(now1.getNano());
		
		System.out.println("------------------------------------------");
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		
		System.out.println(now2.getYear());
		
		System.out.println("------------------------------------------");
		
		LocalDate day = LocalDate.of(2022, 12, 25);
		System.out.println(day);
		
		LocalTime time = LocalTime.of(15, 30, 35);
		System.out.println(time);
		
		LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 11, 17, 05);
		System.out.println(localDateTime);
		
		
		

	}

}
