package chapter11.exam;

import java.util.HashSet;
import java.util.Set;

public class Exam2Main {

	public static void main(String[] args) {
//		2. 축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 
//		입력이 되지 않도록 Set<E> 컬렉션을 이용해서 
//		축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.

//		Set<E> : 중복허용 안함, 저장 순서도 유지하지 않음.
//		중복검사 : hashcode로 검사 -> equals를 통해 중복검사

		Set<FootballPlayer2> players = new HashSet<FootballPlayer2>();
		
		FootballPlayer2 player = new FootballPlayer2("음바페", 7, "생제르멩", 24);
		players.add(player);
		players.add(player);
		players.add(new FootballPlayer2("앙리", 10, "아스널", 25));
		players.add(new FootballPlayer2("반 데이크", 4, "리버풀", 28));
		players.add(new FootballPlayer2("살라", 7, "리버풀", 30));
		players.add(new FootballPlayer2("루니", 10, "맨유", 35));
		players.add(new FootballPlayer2("음바페", 7, "생제르멩", 24));

//		List<E> : 저장 순서를 유지 -> index 값을 가지고, 일괄처리
		System.out.println("보유 선수의 수 : " + players.size());

		System.out.println("보유선수 리스트 ==========");
		for (FootballPlayer2 p : players) {
			System.out.println(p);
		}
	}
}
