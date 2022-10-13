package chapter03;

public class LogicalOperator {

	public static void main(String[] args) {
		
		
		boolean chk1 = true;
		boolean chk2 = false;
		boolean chk3 = true;
		boolean chk4 = false;
		
		System.out.println(chk1 && chk3);
		System.out.println(chk1 && chk2);
		System.out.println(chk2 && chk3);
		System.out.println(chk2 && chk4);
		
		System.out.println("----------");
		
		System.out.println(chk1 || chk3); // true || true
		System.out.println(chk1 || chk2); // true || false
		System.out.println(chk2 || chk3); // false || true
		System.out.println(chk2 || chk4); // false || false
		
		
		
		

	}

}
