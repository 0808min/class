package chapter11.exam;

import java.util.ArrayList;

import java.util.List;


class Main {
	public static void main(String[] args) {
		System.out.println("=====================LIST");
		List<FootballPlayer> list = new ArrayList<FootballPlayer>();
		list.add(new FootballPlayer("Park", 0, "FCA", 0));
		for(FootballPlayer f : list) {
			System.out.println(f);
		}

	}
}