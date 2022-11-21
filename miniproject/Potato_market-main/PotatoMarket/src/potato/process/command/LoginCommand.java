package potato.process.command;

import java.util.HashMap;

import potato.controller.EndpointController;
import potato.controller.sign.SignInController;
import potato.controller.sign.SignUpController;

public class LoginCommand extends AbsCommand {
	
	public LoginCommand() {
		command = new HashMap<>();
		command.put(1, new SignInController());
		command.put(2, new SignUpController());
		command.put(3, new EndpointController());
	}
}
