package chapter15;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpURLConnectionTest {

	public static void main(String[] args) {

		String urlStr = "https://www.google.com";

		try {
			URL url = new URL(urlStr);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			InputStream in = connection.getInputStream();

			for(int i=1; i<=8; i++) {
				System.out.println(connection.getHeaderFieldKey(i) + " = " + connection.getHeaderField(i));
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
