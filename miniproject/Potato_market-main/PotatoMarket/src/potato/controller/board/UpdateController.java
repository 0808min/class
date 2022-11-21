package potato.controller.board;

import potato.domain.Board;
import potato.service.UpdateService;
import potato.util.InputString;
import potato.controller.IController;
import potato.dao.BoardDao;

public class UpdateController implements IController {

	UpdateService service = new UpdateService(new BoardDao());

	public boolean process() {

		int writedate = 0;
		boolean salestatus = true;

		System.out.println("게시글 수정이 시작됩니다.");

		System.out.println("수정할 게시글 번호를 입력해주세요. >> ");
		int boardid = InputString.inputInt();

		System.out.println("카테고리>> /n(1.생활용품, 2.패션/잡화, 3.전자제품, 4.도서, 5.반려동물용품, 6.기타) ");
		int category = InputString.inputInt();

		System.out.println("판매물품 >> ");
		String product = InputString.inputDefaultString();

		System.out.println("판매금액 >> ");
		int saleprice = InputString.inputInt();

		System.out.println("거래지역 >> /n (ex.서울시=>서울, 영양군=>영양)");
		String tradeloc = InputString.inputDefaultString();

		Board board = new Board();
		board.setBoardid(boardid);
		board.setCategory(category);
		board.setProduct(product);
		board.setSaleprice(saleprice);
		board.setTradeloc(tradeloc);
		int result = service.updateByID(board);

		if (result > 0) {
			System.out.println("수정되었습니다.");
		} else {
			System.out.println("수정 실패!");
		}

		return false;

	}

}