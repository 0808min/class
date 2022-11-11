package potato.domain;

import java.io.Serializable;

public class LoginData implements Serializable {
	private String id;
	private String password;
	
	public LoginData(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "LoginData [id=" + id + ", password=" + password + "]";
	}
	
}