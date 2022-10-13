package chapter13;

public class Customer extends Thread {

	Product product;

	public Customer(Product product) {
		super();
		this.product = product;
	}

	@Override
	public void run() {
		System.out.println("오늘 구매한 상품은 " + product.saleProduct() + "입니다.");
		
		
	}

}
