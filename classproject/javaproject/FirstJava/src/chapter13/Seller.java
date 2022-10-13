package chapter13;

public class Seller extends Thread {

	Product product;

	public Seller(Product product) {
		super();
		this.product = product;
	}

	@Override
	public void run() {
		product.setProduct("I phone 14");
		System.out.println("오늘 판매하는 제품은 " + product.product + "입니다.");
	}

}
