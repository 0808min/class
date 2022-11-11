package potato.controller.board;

import potato.controller.IController;
import potato.dao.BoardDao;
import potato.domain.Board;
import potato.domain.Session;
import potato.service.InsertService;
import potato.util.InputString;

public class InsertController implements IController {

	InsertService service = new InsertService(new BoardDao());

	@Override
	public boolean process() {

		int boardid = 0;
		String userid = Session.getInstance().getLoginData().getId();
		int writedate = 0;
		boolean salestatus = true;

		System.out.println("판매글 입력을 시작합니다.");

		System.out.println("카테고리>> /n(1.생활용품, 2.패션/잡화, 3.전자제품, 4.도서, 5.반려동물용품, 6.기타) ");
		int category = InputString.inputInt();

		System.out.println("판매물품 >> ");
		String product = InputString.inputDefaultString();

		System.out.println("판매금액 >> ");
		int saleprice = InputString.inputInt();

		System.out.println("거래지역 >> /n (ex.서울시=>서울, 영양군=>영양)");
		String tradeloc = InputString.inputDefaultString();

		Board board = new Board(boardid, userid, category, product, saleprice, salestatus, writedate, tradeloc);
		int result = service.insert(board);

		if (result > 0) {
			System.out.println("입력되었습니다.");
		} else {
			System.out.println("입력 실패");
		}

		return false;

	}

}
