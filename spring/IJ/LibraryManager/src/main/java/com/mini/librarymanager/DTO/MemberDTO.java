package com.mini.librarymanager.DTO;

public class MemberDTO {
	private String memberEmail; // 사용자 이메일
	private String memberPassword; // 사용자 비밀번호
	private String memberName; // 사용자 이름
	private int memberRank; // 사용자 랭크
	private int memberNormalReturn; // 사용자 정상 반납 숫자
	private int memberReturnAvailable; // 사용자 대여 가능 숫자

	public MemberDTO(String _memberEmail, String _memberPassword, String _memberName) {
		// 데이터 추가할 때
		this.memberEmail = _memberEmail;
		this.memberPassword = _memberPassword;
		this.memberName = _memberName;
	}

	public MemberDTO(String _memberEmail, String _memberPassword, String _memberName, int _memberRank,
			int _memberNormalReturn, int _memberReturnAvailable) {
		// 데이터 받아올 때
		this.memberEmail = _memberEmail;
		this.memberPassword = _memberPassword;
		this.memberName = _memberName;
		this.memberRank = _memberRank;
		this.memberNormalReturn = _memberNormalReturn;
		this.memberReturnAvailable = _memberReturnAvailable;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberRank() {
		return memberRank;
	}

	public void setMemberRank(int memberRank) {
		this.memberRank = memberRank;
	}

	public int getMemberNormalReturn() {
		return memberNormalReturn;
	}

	public void setMemberNormalReturn(int memberNormalReturn) {
		this.memberNormalReturn = memberNormalReturn;
	}

	public int getMemberReturnAvailable() {
		return memberReturnAvailable;
	}

	public void setMemberReturnAvailable(int memberReturnAvailable) {
		this.memberReturnAvailable = memberReturnAvailable;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberEmail=" + memberEmail + ", memberPassword=" + memberPassword + ", memberName="
				+ memberName + ", memberRank=" + memberRank + "]";
	}

}
