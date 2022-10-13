package chapter10;

public class BadInputException extends Exception {


		int score;
		
		public BadInputException(int score) {
			super("입력하신 점수 " + score + "는 범위를 벗어나는 점수입니다.");
			this.score = score;	
		

	}
	

}
