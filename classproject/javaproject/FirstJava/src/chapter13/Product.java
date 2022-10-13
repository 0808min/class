package chapter13;

public class Product {

	String product;

	String saleProduct() {

		if (product == null) {

			try {
				synchronized (this) {
					System.out.println("상품이 준비되지 않아 대기 합니다.");
					wait();

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

//		System.out.println("판매");

		return product;
	}

	public void setProduct(String product) {
		this.product = product;

		synchronized (this) {
			notifyAll();
		}
		
	}

}
