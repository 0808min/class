package Test.A;

public class Test10 extends Exception {
	
	int score;

	
	public Test10(int score) {
		super("입력하신 점수");
		this.score = score;
	}


	public int getScore() {
		return score;
	}
	
	
}
