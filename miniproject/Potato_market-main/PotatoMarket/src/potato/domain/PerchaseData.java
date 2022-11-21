package potato.domain;

public class PerchaseData {

	String userid;
	int boardid;
	int orderid;

	public PerchaseData(String userid, int boardid, int orderid) {
		super();
		this.userid = userid;
		this.boardid = boardid;
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public int getBoardid() {
		return boardid;
	}

	public int getOrderid() {
		return orderid;
	}

	@Override
	public String toString() {
		return "PerchaseData [userid=" + userid + ", boardid=" + boardid + ", orderid=" + orderid + "]";
	}

}
