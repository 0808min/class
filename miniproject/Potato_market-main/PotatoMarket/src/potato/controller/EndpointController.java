package potato.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import potato.domain.Session;

/**
 * 프로그램 종료 할 때, 파일화 작업(자동 로그인 때문에)이 필요해서 만든 클래스
 */
public class EndpointController implements IController {

	@Override
	public boolean process() {
		ObjectOutputStream outStream = null;
		
		try { 
			outStream = new ObjectOutputStream(new FileOutputStream("session.ser"));
			if(Session.getInstance().isLogin())
				outStream.writeObject(Session.getInstance().getLoginData());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.exit(0);
		}
		return true;
	}
}
