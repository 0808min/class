package chapter07;

public class Product {
	
	int price;
	int point;
	
	Product(int price) {
		this.price = price;
		this.point = price/10;
		
	}

}

class TV extends Product {
	TV(int price) {
		super(price);
		
	}

	@Override
	public String toString() {
		return "TV";
	}
	
}

class computer extends Product {
	computer(int price) {
		super(price);
	
	}
	public String toString() {
		return "computer";
	}
}