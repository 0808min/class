package potato.controller.board;

import potato.controller.IController;
import potato.dao.BoardDao;
import potato.domain.Board;
import potato.service.DeleteService;
import potato.util.InputString;

public class DeleteController implements IController {

	DeleteService service = new DeleteService(new BoardDao());

	@Override
	public boolean process() {

		Board board = new Board();
		
		System.out.println("게시글 삭제가 진행됩니다.");

		System.out.println("삭제할 게시글 번호 >>");
		int boardid = InputString.inputInt();

		int result = service.delete(board);

		if (result > 0) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제 실패");
		}

		return false;

	}

}