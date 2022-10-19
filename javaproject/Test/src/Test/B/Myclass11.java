package Test.B;

public class Myclass11<T> {
	
	T val;
	
	T getVal() {
		return val;
	}

	
	void setVal(T val) {
		this.val = val;
	}
	
	public static void main(String[] args) {
		
		Myclass11<String> myClass = new Myclass11<String>();
		String str = myClass.getVal();
		
		myClass.setVal("PARK");  
		System.out.println(myClass.getVal());
		
		
	}
	
}
