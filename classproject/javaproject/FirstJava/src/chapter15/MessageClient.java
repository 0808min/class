package chapter15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MessageClient {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost", 7777);

			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

			String str1 = "";
			String str2 = "";

			Scanner sc = new Scanner(System.in);
			while (true) {

				str1 = sc.nextLine();

				if (str1.equals("exit")) {
					break;
					
				}
				dout.writeUTF(str1);
				dout.flush();

				str2 = din.readUTF();
				System.out.println("Server : " + str2);

			}

			dout.close();
			din.close();
			socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
