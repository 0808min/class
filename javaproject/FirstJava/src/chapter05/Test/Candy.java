package chapter05.Test;

import java.util.Date;
import java.util.Scanner;

public class Candy {

	static int width = 100;
	static int height = 100;
	String type;

	Candy(String type) {
		this.type = type;
		width = 100;
		height = 100;
	}

	public static void main(String[] args) {

		Scanner sc = null;
	    java.util.Date date = null;

//		인스턴스 800개 생성시 -> 변수 2400개 생성
//		인스턴스 800개 생성시 -> 변수 800 + 2개 생성

		Candy c1 = new Candy("허브1");
		Candy c2 = new Candy("허브2");
		Candy c3 = new Candy("허브3");
		Candy c4 = new Candy("허브4");
		Candy c5 = new Candy("허브5");
		Candy c6 = new Candy("허브6");
		Candy c7 = new Candy("허브7");
		Candy c8 = new Candy("허브8");

	}

}
