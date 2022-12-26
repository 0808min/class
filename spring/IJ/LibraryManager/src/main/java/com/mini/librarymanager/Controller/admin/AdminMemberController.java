package com.mini.librarymanager.Controller.admin;

import org.springframework.ui.*;
import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Service.*;
import com.mini.librarymanager.Exception.*;

@Controller
@RequestMapping(value = "/admin/member/*")
public class AdminMemberController {
	// 관리자 페이지 중
	// 알림 부분 중
	// 회원 부분

	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	HopeDAO hopeDAO;

	// 회원 목록 페이지 이동
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String admin_member_show(Model model) {
		List<MemberDTO> memberList = memberDAO.showAll();

		model.addAttribute("memberList", memberList);

		return "admin_member_show";
	}

	// 회원 희망 도서 페이지 이동
	@RequestMapping(value = "/hope", method = RequestMethod.GET)
	public String admin_member_hope(Model model) {
		List<HopeDTO> hopeList = hopeDAO.showAll();
		
		model.addAttribute("hopeList", hopeList);
		
		return "admin_member_hope";
	}

	// 블랙리스트 회원 조회 페이지 이동
	@RequestMapping(value = "/black_show", method = RequestMethod.GET)
	public String admin_member_black_show(Model model) {
		List<MemberDTO> memberBlackList = memberDAO.showBlack();

		model.addAttribute("memberBlackList", memberBlackList);

		return "admin_member_black_show";
	}

	// 블랙리스트 회원 랭크 변경 처리
	@PostMapping(value = "/black_show")
	public void admin_member_black_show(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputMemberEmail = request.getParameter("inputMemberEmail");
			String inputMemberRank = request.getParameter("inputMemberRank");

			MemberDTO memberDTO = memberDAO.selectByEmail(inputMemberEmail);

			if (memberDTO == null)
				throw new NotExistingException("존재하지 않는 계정입니다.");
			else {
				memberService.updateRank(memberDTO, Integer.parseInt(inputMemberRank));
				response.sendRedirect("/admin/member/black_show");
			}
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 계정입니다.'); location.href='/admin/member/black_show';</script>");

			out.flush();
		}
	}
}
