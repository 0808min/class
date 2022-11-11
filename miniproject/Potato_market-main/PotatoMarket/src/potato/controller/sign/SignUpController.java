package potato.controller.sign;

import potato.controller.IController;

public class SignUpController implements IController {

	@Override
	public boolean process() {
		System.out.println("회원가입");
		return true;
	}
}
