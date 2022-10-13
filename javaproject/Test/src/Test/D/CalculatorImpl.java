package Test.D;

public class CalculatorImpl implements Calculator {

	@Override
	public long add(long n1, long n2) {
		// TODO Auto-generated method stub
		return n1 + n2;
	}

	@Override
	public long substract(long n1, long n2) {
		// TODO Auto-generated method stub
		return n1 - n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		// TODO Auto-generated method stub
		return n1 * n2;
	}

	@Override
	public double divide(double n1, double n2) {
		// TODO Auto-generated method stub
		return n1 / n2;
	}

	public static void main(String[] args) {

		CalculatorImpl cal1 = new CalculatorImpl();
		Calculator cal2 = new CalculatorImpl();

		Calculator cal3 = new Calculator() {

			@Override
			public long substract(long n1, long n2) {
				// TODO Auto-generated method stub
				return n1 + n2;
			}

			@Override
			public long multiply(long n1, long n2) {
				// TODO Auto-generated method stub
				return n1 - n2;
			}

			@Override
			public double divide(double n1, double n2) {
				// TODO Auto-generated method stub
				return n1 * n2;
			}

			@Override
			public long add(long n1, long n2) {
				// TODO Auto-generated method stub
				return n1 / n2;
			}
		};
	}

}
