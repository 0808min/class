package Test.F;

public class SmartPhone implements Comparable<SmartPhone> {

	private String name;
	private String phoneNumber;

	public SmartPhone(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public int hashCode() {
		return phoneNumber.charAt(phoneNumber.length() - 1);
//		0 ~ 9사이의 값이 나온다

	}

	@Override
	public boolean equals(Object obj) {

		boolean result = false;

		if (obj != null && obj instanceof SmartPhone) {
			SmartPhone phone = (SmartPhone) obj;
			result = phoneNumber.equals(phone.getPhoneNumber());
		}

		return result;
	}

	@Override
	public int compareTo(SmartPhone o) {
		
		return name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "SmartPhone [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

}
