package chapter11.exam;

public class FootballPlayer implements Comparable<FootballPlayer> {

//	String name;
//	 int number;
//	 String team;
//	 int age

//	1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다. 

	private String name;
	private int number;
	private String team;
	private int age;

	public FootballPlayer(String name, int number, String team, int age) {

		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public String getTeam() {
		return team;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		String str = this.name + this.age + this.team;
		return str.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof FootballPlayer) {
			FootballPlayer f = (FootballPlayer) o;
			if (this.name.equals(f.getName()) && this.age == f.getAge() && this.team.equals(f.getTeam()))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(FootballPlayer f) {
		int compare = this.name.compareTo(f.getName());
		if (compare == 0) {
			compare = Integer.compare(this.number, f.getNumber());
		}
		return compare;

	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}

}
