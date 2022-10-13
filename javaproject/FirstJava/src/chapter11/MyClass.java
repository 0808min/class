package chapter11;

public class MyClass<T> {
	
	T val;
	
	T getVal() {
		return val;
	}
	
	void setVal(T val) {
		this.val = val;
	}
	
	public static void main(String[] args) {
		
//		제네릭 클래스는 인스턴스 생성시에 타입을 결정
		MyClass<String> myClass = new MyClass<String>();
		String str = myClass.getVal();
		
		myClass.setVal("KING");
		System.out.println(myClass.getVal());
		
	}

}
