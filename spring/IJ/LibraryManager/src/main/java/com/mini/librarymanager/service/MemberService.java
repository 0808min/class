package com.mini.librarymanager.Service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;

@Service
public class MemberService {
	private MemberDAO memberDAO;

	@Autowired
	public MemberService(MemberDAO _memberDAO) {
		this.memberDAO = _memberDAO;
	}

	public MemberDTO registMember(MemberDTO _memberDTO) {
		// 회원가입
		MemberDTO memberDTO = memberDAO.selectByEmail(_memberDTO.getMemberEmail());

		if (memberDTO == null) { // 회원 존재하지 않음 --> 회원가입 진행
			memberDAO.insertMember(_memberDTO);

			return _memberDTO; // 가입한 계정 반환
		} else {
			System.out.println("이미 존재하는 계정입니다.");

			return null; // null 반환
		}
	}

	public MemberDTO loginMember(String inputEmail, String inputPassword) {
		// 로그인
		MemberDTO memberDTO = memberDAO.selectByEmail(inputEmail);

		if (memberDTO == null) {
			System.out.println("이메일 입력 에러");
			return null;
		} else if (!memberDTO.getMemberPassword().equals(inputPassword)) {
			// 비밀번호 오류
			System.out.println("비밀번호 에러");
			return null;
		}

		return memberDTO;
	}

	public MemberDTO changePassword(MemberDTO _memberDTO, StringBuffer newPassword) {
		// 비밀번호 수정
		memberDAO.updatePassword(_memberDTO, newPassword.toString());

		return memberDAO.selectByEmail(_memberDTO.getMemberEmail());
	}

	public void updateRank(MemberDTO memberDTO, int inputMemberRank) {
		// 회원 랭크 수정
		memberDAO.updateRank(memberDTO, inputMemberRank);
	}

	public void sendEmail(MemberDTO memberDTO, String div) throws Exception {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; // 지메일 이용시 smtp.gmail.com
		String hostSMTPid = ""; // "서버 이메일 주소(보내는 사람 이메일 주소)";
		String hostSMTPpwd = ""; // "서버 이메일 비번(보내는 사람 이메일 비번)";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "admin@admin"; // "보내는 사람 이메일주소(받는 사람 이메일에 표시됨)";
		String fromName = "MinGW"; // "프로젝트이름 또는 보내는 사람 이름";
		String subject = "";
		String msg = "";

		if (div.equals("forgotPwd")) {
			subject = "Min Library 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += memberDTO.getMemberName() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += memberDTO.getMemberPassword() + "</p></div>";
		}

	}
}
