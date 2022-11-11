package potato.domain;

import java.sql.Timestamp;

/**
 * 정상적으로 로그인 했을 떄, 공유하게 되는 유저 데이터. 
 * 프로그램이 실행되는동안 필요로 함, 정상 종료시에는 직렬화 하여 데이터를 저장, 다음에 로그인 할 때 자동으로 로그인이 되도록 처리
 * 자동 로그인 처리를 위하여 비밀번호 또한 저장하는 구조이지만 실제 세션에서는 비밀번호 사용해선 안됨
 * loginTime을 통해서 최종 로그인(최종 데이터 확인 시간) 체크
 */
public class Session {
	private LoginData loginData;
	private Timestamp loginTime;
	private static Session instance;
	
	private Session() {
		loginData = null;
		loginTime = null;
	}
	
	public static Session getInstance() {
		if(instance == null) {
			instance = new Session();
		}
		return instance;
	}
	
	public boolean isLogin() {
		return loginData != null ? true : false;
	}
	
	public void createSession(String id, String password) {
		if(id == null || password == null || id.equals("") || password.equals("")) return;
		
		this.loginData = new LoginData(id, password);
		this.loginTime = new Timestamp(System.currentTimeMillis());
	}
	
	public void createSession(LoginData data) {
		this.loginData = data;
		this.loginTime = new Timestamp(System.currentTimeMillis());
	}
	
	public void destroySession() {
		this.loginData = null;
		this.loginTime = null;
	}
	
	public void updateSession() {
		this.loginTime = new Timestamp(System.currentTimeMillis());
	}

	public String getId() {
		return loginData.getId();
	}
	
	public String getPw() {
		return loginData.getPassword();
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}
	
	public LoginData getLoginData() {
		return loginData;
	}
	
	
	
}
