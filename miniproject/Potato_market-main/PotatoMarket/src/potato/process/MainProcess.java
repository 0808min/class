package potato.process;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import potato.controller.EndpointController;
import potato.domain.LoginData;
import potato.domain.Session;
import potato.process.command.AbsCommand;
import potato.process.command.LoginCommand;
import potato.process.command.MainCommand;
import potato.service.UserService;
import potato.util.ConnectionProvider;
import potato.util.InputString;

/**
 * initialize 시켜야 함
 *
 */
public class MainProcess {
	private static MainProcess instance = null;
	private MainProcess() {}
	
	public static MainProcess getInstance() {
		if(instance == null) {
			instance = new MainProcess();
		}
		
		return instance;
	}
	
	/**
	 * 최초 실행시 필요한 작업
	 */
	public void initialize() {
		JSONParser parser = new JSONParser();
		FileReader fr = null;
		try {
			fr = new FileReader("config.json");
			Object obj = parser.parse(fr);
			JSONObject config = (JSONObject) obj;
			
			ConnectionProvider.initializeConnect((String)config.get("dbUrl"), 
					(String)config.get("dbUser"), 
					(String)config.get("dbPassword"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0); // config파일 불러오기 실패할 경우 db를 실행할 수 없으므로 종료 시켜야 함
		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		Session session = Session.getInstance(); 
		ObjectInputStream inStream = null;
		
		try {
			inStream = new ObjectInputStream(new FileInputStream("session.ser"));
			
			if(inStream != null) {
				session.createSession((LoginData)inStream.readObject());
			}
		} catch (Exception e) {
			// 기본 로그인 데이터 없는 거니까 굳이 오류 표시 x
		} finally {
			if(inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void loginProcess() {
		if(Session.getInstance().isLogin()) {
			long now = System.currentTimeMillis();
			long lastLoginTime = Session.getInstance().getLoginTime().getTime();
			if((now - lastLoginTime < (24 * 60 * 60 * 1000))) {
				UserService service = new UserService();
				// 로그인 데이터 있을 경우 db에 데이터 비교해서 정상적인 로그인 처리 필요.
				if(service.signIn(Session.getInstance().getLoginData())) {
					System.out.println("자동 로그인 성공!");
					Session.getInstance().updateSession();
					return;
				}
				Session.getInstance().destroySession();
			}
		}
		
		AbsCommand command = new LoginCommand();
		
		int inputMenu;
		while(true) {
			System.out.println("======================");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 종료");
			System.out.println("======================");
			System.out.print("작업을 입력해주세요:>>");
			try {
				inputMenu = InputString.inputInt();
				
				// 여기서 로그인 or 회원가입 처리 하도록 해야 합니다.
				if(command.command.get(inputMenu).process() && inputMenu == 1) {
					//로그인 성공이니까 멈춰야함
					System.out.println("로그인 성공");
					break;
				}
			} catch(Exception e) {
				System.out.println("작업에 오류가 발생하였습니다. 다시 시도해주세요.");
				continue;
			}
		}
		
	}
	
	public void mainProcess() {
		AbsCommand command = new MainCommand();
		int inputMenu;
		while(true) {
			System.out.println("======================");
			System.out.println("1. 전체글 보기");
			System.out.println("2. 내 판매글 보기");
			System.out.println("3. 내 구매내역 보기");
			System.out.println("4. 회원 정보 보기");
			System.out.println("5. 프로그램 종료");
			System.out.println("======================");
			System.out.print("작업을 입력해주세요:>>");
			try {
				inputMenu = InputString.inputInt();
				
				command.command.get(inputMenu).process(); // 여기에... 이제 처리 해주시면 됩니다. 여기가 루프 돌아야 합니다.
			} catch(Exception e) {
				System.out.println("작업에 오류가 발생하였습니다. 다시 시도해주세요.");
				continue;
			}
		}
	}
	
	public void endpointProcess() {
		new EndpointController().process();
	}
}
