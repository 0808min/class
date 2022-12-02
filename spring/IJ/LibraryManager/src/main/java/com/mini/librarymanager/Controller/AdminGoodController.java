package com.mini.librarymanager.Controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.mini.librarymanager.DAO.*;
import com.mini.librarymanager.DTO.*;
import com.mini.librarymanager.Service.*;
import com.mini.librarymanager.Exception.*;

@Controller
@RequestMapping(value = "/admin/alarm/good/*")
public class AdminGoodController {
	// 관리자 페이지 중
	// 알림 부분 중
	// 사서 추천 도서 부분
	
	@Autowired
	GoodService goodService;
	@Autowired
	GoodDAO goodDAO;

	@Autowired
	BookDAO bookDAO;

	// 사서 추천 도서 추가 페이지 이동
	@RequestMapping(value = "/good_add", method = RequestMethod.GET)
	public String admin_alarm_good_add(Model model) {
		List<GoodDTO> goodList = goodDAO.showAll();
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("goodList", goodList);
		model.addAttribute("bookList", bookList);

		return "admin_alarm_good_add";
	}

	// 사서 추천 도서 추가 처리
	@PostMapping(value = "/good_add")
	public void admin_alarm_good_add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputGoodISBN = request.getParameter("inputGoodISBN");
			String inputGoodTitle = request.getParameter("inputGoodTitle");
			String inputGoodContent = request.getParameter("inputGoodContent").replaceAll("\r\n", "<br />");;

			BookDTO bookDTO = bookDAO.selectByISBN(inputGoodISBN);

			if (bookDTO == null)
				throw new NotExistingException("존재하지 않는 도서입니다.");

			GoodDTO goodDTO = new GoodDTO(inputGoodISBN, inputGoodTitle, inputGoodContent);

			goodDTO = goodService.uploadGood(goodDTO);

			if (goodDTO == null) {
				throw new AlreadyExistingException("이미 존재하는 추천 도서입니다.");
			} else {
				System.out.println(goodDTO);

				response.sendRedirect("/admin/alarm/good/good_add");
			}
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 추천 도서입니다.'); location.href='/admin/alarm/good/good_add';</script>");

			out.flush();
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 도서입니다.'); location.href='/admin/alarm/good/good_add';</script>");

			out.flush();
		}
	}

	// 사서 추천 도서 삭제 페이지 이동
	@RequestMapping(value = "/good_delete", method = RequestMethod.GET)
	public String admin_alarm_good_delete(Model model) {
		List<GoodDTO> goodList = goodDAO.showAll();

		model.addAttribute("goodList", goodList);

		return "admin_alarm_good_delete";
	}

	// 사서 추천 도서 삭제 처리
	@PostMapping(value = "/good_delete")
	public void admin_alarm_good_delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputGoodID = request.getParameter("inputGoodID");
			String inputGoodTitle = request.getParameter("inputGoodTitle");
			String inputGoodTitleConfirm = request.getParameter("inputGoodTitleConfirm");

			GoodDTO goodDTO = goodDAO.selectByID(Integer.parseInt(inputGoodID));

			if (goodDTO == null)
				throw new NotExistingException("존재하지 않는 추천 도서입니다.");
			else {
				if (inputGoodTitle.equals(inputGoodTitleConfirm)) {
					goodService.deleteGood(goodDTO);

					response.sendRedirect("/admin/alarm/good/good_delete");
				} else
					throw new NotMatchingException("게시글 제목이 맞지 않습니다.");
			}
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 추천 도서입니다.'); location.href='/admin/alarm/good/good_delete';</script>");

			out.flush();
		} catch (NotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('게시글 제목이 맞지 않습니다.'); location.href='/admin/alarm/good/good_delete';</script>");

			out.flush();
		}
	}
}