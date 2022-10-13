package chapter11;

public class Box {
	
//	void push(Orange o) {
//		o.print();
//	}
//	
//	void push(Apple a) {
//		a.print();
//	}
	
	void push(Object o) {
		System.out.println(o);
	}

}

class Apple {
	void print() {
		System.out.println("Apple");
	}
}

class Orange {
	void print() {
		System.out.println("Orange");
	}
	
	public static void main(String[] args) {
		Box box = new Box();
		box.push(new Orange());
		box.push(new Apple());
//		box.push(new String("Apple"));
	}
}