package chapter15;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

	public static void main(String[] args) {

		String urlStr = "https://www.google.com";

		try {
			URL url = new URL(urlStr);

			URLConnection connection = url.openConnection();

			InputStream in = connection.getInputStream();

			while (true) {
				int data = in.read();

				if (data == -1) {
					break;
				}

				System.out.print((char) data);
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
