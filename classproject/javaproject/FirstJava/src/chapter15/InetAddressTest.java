package chapter15;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	
	public static void main(String[] args) {
		
		String hostName = "www.naver.com";
		
		try {
			InetAddress ip = InetAddress.getByName(hostName);
			
			System.out.println(ip.getHostName());
			System.out.println(ip.getHostAddress());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
