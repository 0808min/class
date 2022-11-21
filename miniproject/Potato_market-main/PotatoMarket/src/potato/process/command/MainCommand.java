package potato.process.command;

import java.util.HashMap;

import potato.controller.EndpointController;
import potato.controller.board.PrintController;

public class MainCommand extends AbsCommand {

	public MainCommand(){
		command = new HashMap<>();
		command.put(1, new PrintController()); // 전체글 보기
		//command.put(2, )// 판매글
		//command.put(3, ); // 구매내역
		//command.put(4, ); // 회원 정보
		command.put(5, new EndpointController()); // 종료
	}
}
