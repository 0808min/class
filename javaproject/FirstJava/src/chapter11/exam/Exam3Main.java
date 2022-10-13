package chapter11.exam;

import java.util.TreeSet;

public class Exam3Main {

	public static void main(String[] args) {
//		3. TreeSet<E>을 이용해서 
//		팀 이름순으로 정렬하고, 
//		같은 팀의 선수들은 이름 순으로 정렬하고, 
//		같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
		
		TreeSet<FootballPlayer2> players = new TreeSet<>();
		

		
		FootballPlayer2 player = new FootballPlayer2("음바페", 7, "생제르멩", 24);
		players.add(player);
		players.add(new FootballPlayer2("앙리", 10, "아스널", 25));
		players.add(new FootballPlayer2("반 데이크", 4, "리버풀", 28));
		players.add(new FootballPlayer2("살라", 7, "리버풀", 30));
		players.add(new FootballPlayer2("루니", 10, "맨유", 35));
		players.add(new FootballPlayer2("음바페", 17, "생제르멩", 24));

//		List<E> : 저장 순서를 유지 -> index 값을 가지고, 일괄처리
		System.out.println("보유 선수의 수 : " + players.size());

		System.out.println("보유선수 리스트 ==========");
		for (FootballPlayer2 p : players) {
			System.out.println(p);
		}

	}

}
