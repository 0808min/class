package Test.B;

public class Test11 {

//	void push(Orange o) {
//		o.print();
//	}
//
//	void push(Apple a) {
//		a.print();
//	}
	
	void push(Object o) {
//		o.print();
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
		
		Test11 box = new Test11();
		box.push(new Orange());
		box.push(new Apple());
		box.push(new String("Apple"));
		
		
	}
}
