package chapter11.exam;

import java.util.ArrayList;
import java.util.List;

public class Exam1Main {

	public static void main(String[] args) {
//		1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 
//		인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.

		List<FootballPlayer2> players = new ArrayList<>();

//		List<E> -> 저장메소드 add(new FootballPlayer2());
		FootballPlayer2 player = new FootballPlayer2("음바페", 7, "생제르멩", 24);
		players.add(player);
		players.add(player);
		players.add(new FootballPlayer2("앙리", 10, "아스널", 25));
		players.add(new FootballPlayer2("반 데이크", 4, "리버풀", 19));
		players.add(new FootballPlayer2("박지성", 7, "맨유", 35));
		players.add(new FootballPlayer2("루니", 10, "맨유", 35));
		players.add(new FootballPlayer2("음바페", 7, "생제르멩", 24));

//		List<E> : 저장 순서를 유지 -> index 값을 가지고, 일괄처리
		System.out.println("나의 선수 리스트");
		for (FootballPlayer2 p : players) {
			System.out.println(p);
		}

	}

}
