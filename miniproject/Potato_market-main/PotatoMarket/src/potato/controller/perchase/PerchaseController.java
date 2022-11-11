package potato.controller.perchase;

import potato.controller.IController;
import potato.dao.PerchaseDao;
import potato.domain.PerchaseData;
import potato.service.PerchaseService;
import potato.util.InputString;

public class PerchaseController implements IController {

	PerchaseService service = new PerchaseService(new PerchaseDao());

	@Override
	public boolean process() {
 
		String userid;
		int boardid, orderid;

		System.out.println("구매내역 조회");

		System.out.println("아이디 입력 >> ");
		userid = InputString.inputDefaultString();
		System.out.println("게시글번호 입력 >> ");
		boardid = InputString.inputInt();
		System.out.println("주문번호 입력 >> ");
		orderid = InputString.inputInt();

		PerchaseData perchasedata = new PerchaseData(userid, boardid, orderid);
		int result = service.perchase(perchasedata);
		
		if (result > 0) {
			System.out.println("입력되었습니다.");
		} else {
			System.out.println("입력 실패");
		}
		
		
		return false;
	}

}
