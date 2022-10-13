package chapter11;

import java.util.Objects;

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
	public int compareTo(SmartPhone o) {
		
		return name.compareTo(o.getName());
	}
	

	@Override
	public String toString() {
		return "SmartPhone [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}


//	HashSet 중복 저장을 하지 않는다.
//	hashcode 참조 -> equals 메소드로 비교
	
	
	
//	@Override
//	public int hashCode() {
//		return phoneNumber.charAt(phoneNumber.length()-1);
//	}
//	
//	public boolean equals(Object obj) {
//		
//		if(obj != null && obj instanceof SmartPhone) {
//			SmartPhone phone = (SmartPhone) obj;
//			result = phoneNumber.equals(phone.getPhoneNumber());
//		}
//		
//		return result;
		
	}

	
	
	
	


