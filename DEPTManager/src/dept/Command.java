package dept;

import java.util.HashMap;
import java.util.Map;

import dept.controller.Controller;
import dept.controller.DeleteController;
import dept.controller.ExitController;
import dept.controller.InsertController;
import dept.controller.SelectByController;
import dept.controller.SelectController;
import dept.controller.UpdateController;

public class Command {
	
	public Map<Integer, Controller> command;
	
	public Command() {
		command = new HashMap<>();
		command.put(1, new SelectController());
		command.put(2, new SelectByController());
		command.put(3, new UpdateController());
		command.put(4, new InsertController());
		command.put(5, new DeleteController());
		command.put(6, new ExitController());
	}


}
