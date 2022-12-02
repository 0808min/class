package com.mini.librarymanager.Controller;

import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Service.*;


@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;

	@Autowired
	BookDAO bookDAO;



	// 회원가입 페이지 이동
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String member_register() {
		return "member_register";
	}

	// 회원가입 처리
	@PostMapping(value = "/register")
	public void member_register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputName = request.getParameter("inputName");
			String inputEmail = request.getParameter("inputEmail");
			String inputPassword = request.getParameter("inputPassword");
			String confirmPassword = request.getParameter("inputPasswordConfirm");

			MemberDTO memberDTO = new MemberDTO(inputEmail, inputPassword, inputName);

			if (inputPassword.equals(confirmPassword))
				memberDTO = memberService.registMember(memberDTO);
			else
				throw new NotMatchingException("확인 비밀번호와 맞지 않습니다.");

			if (memberDTO == null) {
				throw new AlreadyExistingException("이미 존재하는 계정입니다.");
			} else {
				System.out.println(memberDTO.toString());

				response.sendRedirect("/member/login");
			}
		} catch (NotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('확인 비밀번호와 맞지 않습니다.'); location.href='/member/register';</script>");

			out.flush();
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 계정입니다.'); location.href='/member/register';</script>");

			out.flush();
		}
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String member_login() {
		return "member_login";
	}

	// 로그인 처리
	@PostMapping(value = "/login")
	public void member_login(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession(true);

			String inputEmail = request.getParameter("inputEmail");
			String inputPassword = request.getParameter("inputPassword");

			MemberDTO memberDTO = memberService.loginMember(inputEmail, inputPassword);

			if (memberDTO == null) {
				System.out.println("로그인 에러 in Controller");

				response.sendRedirect("/member/login");
			} else if (memberDTO.getMemberEmail().equals("admin@admin")) {
				session.setAttribute("loginMemberName", memberDTO.getMemberName());
				// session.setAttribute("loginMemberDTO", memberDTO);
				response.sendRedirect("/admin_index");
			} else {
				session.setAttribute("loginMemberName", memberDTO.getMemberName());
				session.setAttribute("loginMemberDTO", memberDTO);
				response.sendRedirect("/member_index");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/forgotPwd", method = RequestMethod.GET)
	public String member_forgotPwd() {
		return "member_forgotPwd";
	}

	@PostMapping("/forgotPwd")
	public void member_forgotPwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputEmail = request.getParameter("inputEmail");

			MemberDTO memberDTO = memberDAO.selectByEmail(inputEmail);

			if (memberDTO == null) { // 존재하지 않는 계정
				throw new NotExistingException("존재하지 않는 계정입니다.");
			} else { // 계정이 존재한다면
				StringBuffer newPassword = new StringBuffer();

				Random rand = new Random();

				// 임시 비밀번호 생성
				for (int i = 0; i < 10; i++) {
					int index = rand.nextInt(3);
					switch (index) {
					case 0:
						newPassword.append((char) ((int) (rand.nextInt(26)) + 97));
						break;
					case 1:
						newPassword.append((char) ((int) (rand.nextInt(26)) + 65));
						break;
					case 2:
						newPassword.append((rand.nextInt(10)));
						break;
					}
				}

				memberDTO = memberService.changePassword(memberDTO, newPassword);

				memberService.sendEmail(memberDTO, "forgotPwd");

				response.sendRedirect("/member/login");
			}
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 계정입니다.'); location.href='/member/register';</script>");

			out.flush();
		}
	}

	// 마이 페이지
	@RequestMapping(value = "/my_page", method = RequestMethod.GET)
	public String member_my_page(Model model, HttpSession session) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");

		List<PhraseDTO> phraseList = phraseDAO.showAll();
		List<CheckOutDTO> checkOutList = checkOutDAO.selectByEmail(memberDTO.getMemberEmail());

		model.addAttribute("checkOutList", checkOutList);
		model.addAttribute("phraseList", phraseList);

		return "member_my_page";
	}

	@GetMapping("/logout")
	public String member_logout(final HttpSession session) {
		if (session.getAttribute("loginMemberName") != null)
			session.removeAttribute("loginMemberName");

		session.invalidate();

		return "redirect:/";
	}

	// 도서 반납
	@PostMapping("/my_page/return_book")
	public void member_return(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		String inputISBN = request.getParameter("inputReturnISBN");

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");

		BookDTO bookDTO = bookDAO.selectByISBN(inputISBN);

		CheckOutDTO checkOutDTO = checkOutDAO.getOneCheckOut(memberDTO.getMemberEmail(), inputISBN);

		// 날짜 확인
		Date nowDate = new Date(new java.util.Date().getTime());
		System.out.println(nowDate);

		if (nowDate.before(checkOutDTO.getCheckOutReturnDueDate())) // 연체 중이 아니면
			memberDTO.setMemberNormalReturn(memberDTO.getMemberNormalReturn() + 1); // 정상 반납 + 1
		else
			memberDTO.setMemberNormalReturn(memberDTO.getMemberNormalReturn() - 1); // 정상 반납 - 1

		memberDAO.updateMemberNormalReturn(memberDTO);
		// 대여 가능 횟수 + 1
		memberDTO.setMemberReturnAvailable(memberDTO.getMemberReturnAvailable() + 1);
		memberDAO.updateMemberReturnAvailable(memberDTO);

		bookDTO.setBookCount(bookDTO.getBookCount() + 1);
		bookDAO.updateBook(bookDTO); // 도서 재고 수 + 1

		if (memberDTO.getMemberNormalReturn() >= 5) // VIP 조건 달성
			memberDAO.updateRank(memberDTO, 1);
		else if (memberDTO.getMemberNormalReturn() <= -3) // 블랙리스트 조건 달성
			memberDAO.updateRank(memberDTO, -1);

		checkOutDAO.returnCheckOut(memberDTO.getMemberEmail(), inputISBN); // 반납 처리
		session.setAttribute("loginMemberDTO", memberDTO);
		response.sendRedirect("/member/my_page");
	}

	// 도서 연장
	@PostMapping("/my_page/extend_date")
	public void member_extension(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		try {
			String inputISBN = request.getParameter("inputExtensionISBN");

			MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");

			CheckOutDTO checkOutDTO = checkOutDAO.getOneCheckOut(memberDTO.getMemberEmail(), inputISBN);

			// 연장 최대 횟수는 3
			if (checkOutDTO.getCheckOutExtensionCount() >= 3)
				throw new NotAvailableException("연장하실 수 없습니다.");

			// 날짜 확인
			Date nowDate = new Date(new java.util.Date().getTime());
			if (nowDate.after(checkOutDTO.getCheckOutReturnDueDate())) // 연체 중이면
				throw new NotAvailableException("연장하실 수 없습니다.");

			checkOutDAO.extendCheckOut(memberDTO.getMemberEmail(), inputISBN); // 연장 처리

			session.setAttribute("loginMemberDTO", memberDTO);
			response.sendRedirect("/member/my_page");
		} catch (NotAvailableException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('연장하실 수 없습니다.'); location.href='/member/my_page';</script>");

			out.flush();
		}
	}

	// 비밀번호 수정 페이지 이동
	@RequestMapping(value = "/change_password", method = RequestMethod.GET)
	public String member_change_password() {
		return "member_change_password";
	}

	// 비밀번호 수정 처리
	@PostMapping("/change_password")
	public void member_change_password(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");

			String inputOldPassword = request.getParameter("inputOldPassword");
			String inputNewPassword = request.getParameter("inputNewPassword");
			String inputNewPasswordConfirm = request.getParameter("inputNewPasswordConfirm");

			if (memberDTO.getMemberPassword().equals(inputOldPassword)) {
				if (inputNewPassword.equals(inputNewPasswordConfirm)) {
					memberDAO.updatePassword(memberDTO, inputNewPassword);

					response.sendRedirect("/member/my_page");
				} else
					throw new NotMatchingException("비밀번호가 맞지 않습니다.");
			} else
				throw new NotMatchingException("비밀번호가 맞지 않습니다.");

		} catch (NotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('비밀번호가 맞지 않습니다.'); location.href='/member/change_password';</script>");

			out.flush();
		}
	}

	// 희망 도서 신청 페이지 이동
	@RequestMapping(value = "/member_hope", method = RequestMethod.GET)
	public String member_hope(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "member_hope";
	}

	// 희망 도서 신청 처리
	@PostMapping(value = "/member_hope")
	public void member_hope(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputBookISBN = request.getParameter("inputBookISBN");
			String inputBookTitle = request.getParameter("inputBookTitle");
			String inputBookLink = request.getParameter("inputBookLink");

			BookDTO bookDTO = bookDAO.selectByISBN(inputBookISBN);

			if (bookDTO == null) { // 도서 없을 때
				HopeDTO hopeDTO = hopeDAO.selectByISBN(inputBookISBN);
				if (hopeDTO == null) { // 희망 도서 신청 내역이 없을 때
					hopeDTO = new HopeDTO(inputBookISBN, inputBookTitle, 1, inputBookLink);
					hopeDAO.insertHope(hopeDTO);

					response.sendRedirect("/member/member_hope");
				} else {
					hopeDAO.updateHope(hopeDTO);

					response.sendRedirect("/member/member_hope");
				}
			} else
				throw new AlreadyExistingException("이미 존재하는 도서입니다.");
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 도서입니다.'); location.href='/member/member_hope';</script>");

			out.flush();
		}
	}
}
