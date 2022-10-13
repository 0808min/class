package chapter15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MessageServer {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(7777);
			System.out.println("소켓 서버가 실행되었습니다.");

			Socket socket = serverSocket.accept();
			System.out.println("클라이언트가 접속했습니다.");

			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

			Scanner sc = new Scanner(System.in);

//			전송 문자열 
			String str1 = "";
//			수신 문자열
			String str2 = "";

			while (true) {
				str2 = din.readUTF();
				System.out.println("Client : " + str2);

				str1 = sc.nextLine();

				if (str1.equals("exit")) {
					break;
				}

				dout.writeUTF(str1);

			}
			
			din.close();
			dout.close();
			socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
