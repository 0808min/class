package potato.process.command;

import java.util.HashMap;

import potato.controller.board.DeleteController;
import potato.controller.board.SellHistoryController;
import potato.controller.board.UpdateController;

public class BoardCommand extends AbsCommand {
	
	public BoardCommand() {
		command = new HashMap<>();
		//command.put(1, new ); // 검색
		//command.put(2, new ); // 구매
		command.put(3, new UpdateController()); // 수정
		command.put(4, new DeleteController()); // 삭제
		//command.put(5, new SellHistoryController()); // 판매 내역 확인
		//command.put(6, new ()); // 돌아가기	
		
		
	}

}
